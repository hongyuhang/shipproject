package com.cbdz.sib.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cbdz.sib.dao.MenuItemCheckMapper;
import com.cbdz.sib.dao.MenuItemMapper;
import com.cbdz.sib.model.MenuItem;
import com.cbdz.sib.model.MenuItemCheck;
import com.cbdz.sib.model.MenuItemCheckExample;
import com.cbdz.sib.model.MenuItemExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PageItemService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MenuItemMapper g_mapperMenuItem;
    @Autowired
    private MenuItemCheckMapper g_mapperMenuItemCheck;

    @Transactional
    public Map<String, Object> getPageItemByMenuCd(String x_menuCd) {

        Map<String, Object> p_ret = new HashMap<>();
        // 构造画面显示元素
        List<Map<String, Object>> p_itemsRet = new ArrayList();
        List<MenuItem> p_itemsDb = this.getItems(x_menuCd);
        for (MenuItem per : p_itemsDb) {
            Map<String, Object> p_tmp = new HashMap<>();
            p_tmp.put("type", per.getItemType());
            p_tmp.put("label", per.getItemLabel());
            p_tmp.put("id", per.getItemId());
            p_tmp.put("placeholder", per.getItemPlaceholder());
            p_tmp.put("val", per.getItemInitval());
            if (!StringUtils.isEmpty(per.getItemSelText())) {
                List<Map<String, String>> options = new ArrayList<>();
                Map<String, String> opt1 = new HashMap<>();
                opt1.put("","");
                options.add(opt1);

                String[] p_selTmp = per.getItemSelText().split(";");
                for (int i = 0; i < p_selTmp.length; i++) {
                    String[] p_keyval = p_selTmp[i].split("=");
                    if (p_keyval.length == 2) {
                        Map<String, String> opt2 = new HashMap<>();
                        opt2.put(p_keyval[0],p_keyval[1]);
                        options.add(opt2);
                    }
                }
                p_tmp.put("vals", options);
            }
            p_itemsRet.add(p_tmp);
        }
        p_ret.put("items", p_itemsRet);

        // 构造画面各字段校验
        Map<String, Object> p_checkRules = new HashMap<>();
        Map<String, Object> p_checkMsgs = new HashMap<>();
        List<MenuItemCheck> p_checksDb = this.getItemChecks(x_menuCd);
        for (MenuItemCheck per : p_checksDb) {
            Map<String, Object> p_tmpCheckRule = null;
            if (p_checkRules.containsKey(per.getItemId())) {
                p_tmpCheckRule = (Map<String, Object>) p_checkRules.get(per.getItemId());
            } else {
                p_tmpCheckRule = new HashMap<>();
                p_checkRules.put(per.getItemId(), p_tmpCheckRule);
            }
            if (StringUtils.equals(per.getCheckMethod(), "dataTypeCheck")) {
                Map<String, Object> p_dataTypeTmp = new HashMap<>();
                p_dataTypeTmp.put("dataType", per.getCheckParam());
                p_tmpCheckRule.put(per.getCheckMethod(), p_dataTypeTmp);
            } else {
                p_tmpCheckRule.put(per.getCheckMethod(), per.getCheckParam());
            }


            Map<String, Object> p_tmpCheckMsg = null;
            if (p_checkMsgs.containsKey(per.getItemId())) {
                p_tmpCheckMsg = (Map<String, Object>) p_checkMsgs.get(per.getItemId());
            } else {
                p_tmpCheckMsg = new HashMap<>();
                p_checkMsgs.put(per.getItemId(), p_tmpCheckMsg);
            }
            p_tmpCheckMsg.put(per.getCheckMethod(), per.getErrMsg());
        }
        p_ret.put("checkRules", p_checkRules);
        p_ret.put("checkMessages", p_checkMsgs);

        logger.info(JSON.toJSONString(p_ret, true));

        return p_ret;
    }

    private List<MenuItem> getItems(String x_menuCd) {
        MenuItemExample p_where = new MenuItemExample();
        p_where.createCriteria().andMCodeEqualTo(x_menuCd);
        p_where.setOrderByClause("item_dispno");
        return g_mapperMenuItem.selectByExample(p_where);
    }
    private List<MenuItemCheck> getItemChecks(String x_menuCd) {
        MenuItemCheckExample p_where = new MenuItemCheckExample();
        p_where.createCriteria().andMCodeEqualTo(x_menuCd);
        return g_mapperMenuItemCheck.selectByExample(p_where);
    }
}