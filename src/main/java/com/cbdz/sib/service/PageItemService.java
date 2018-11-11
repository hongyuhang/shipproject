package com.cbdz.sib.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cbdz.sib.common.AppUtils;
import com.cbdz.sib.common.Constant;
import com.cbdz.sib.dao.*;
import com.cbdz.sib.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PageItemService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MenuMapper g_mapperMenu;
    @Autowired
    private MenuItemMapper g_mapperMenuItem;
    @Autowired
    private MenuItemCheckMapper g_mapperMenuItemCheck;
    @Autowired
    private MenuSubAreaMapper g_mapperMenuSubArea;
    @Autowired
    private MmsiCurrentMapper g_mapperMmsi;

    @Transactional
    public Map<String, Object> getPageItemByMenuCd(String x_menuCd) {

        Map<String, Object> p_ret = new HashMap<>();
        // 构造画面显示元素
        List<Map<String, Object>> p_itemsRet = new ArrayList();
        List<MenuItem> p_itemsDb = this.getItems(x_menuCd);
        Menu p_menu = this.getMenu(x_menuCd);
        p_ret.put("title", p_menu.getmName());
        for (MenuItem per : p_itemsDb) {
            Map<String, Object> p_tmp = new HashMap<>();
            p_tmp.put("type", per.getItemType());
            p_tmp.put("label", per.getItemLabel());
            p_tmp.put("id", per.getItemId());
            p_tmp.put("placeholder", AppUtils.getDefault(per.getItemPlaceholder(), ""));
            p_tmp.put("val", AppUtils.getDefault(per.getItemInitval(), ""));
            if (StringUtils.isEmpty(per.getInitEnableFlag())) {
                p_tmp.put("disabled", true);
            }
            // 确定下拉框等固定字符串的内容
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
            } else if (StringUtils.equals(per.getItemId(), "destinationMmsi")) {
                // 发送对象的场合，构造下拉列表
                List<MmsiCurrent> p_listDb = getMmisCurrent();
                List<Map<String, String>> options = new ArrayList<>();
                Map<String, String> opt1 = new HashMap<>();
                opt1.put("","");
                options.add(opt1);

                for (int i = 0; i < p_listDb.size(); i++) {
                    MmsiCurrent p_tmpMmsi = p_listDb.get(i);
                    Map<String, String> opt2 = new HashMap<>();
                    opt2.put(p_tmpMmsi.getMmsi(), p_tmpMmsi.getMmsi() + " " + p_tmpMmsi.getName());
                    options.add(opt2);
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
        Map<String, Boolean> p_numObjects = new HashMap<>();
        for (MenuItemCheck per : p_checksDb) {
            Map<String, Object> p_tmpCheckRule = null;
            if (p_checkRules.containsKey(per.getItemId())) {
                p_tmpCheckRule = (Map<String, Object>) p_checkRules.get(per.getItemId());
            } else {
                p_tmpCheckRule = new HashMap<>();
                p_checkRules.put(per.getItemId(), p_tmpCheckRule);
            }
            if (StringUtils.equals(per.getCheckMethod(), "number")
                && StringUtils.equals(per.getCheckParam(), "true")) {
                p_numObjects.put(per.getItemId(), true);
            }
            if (StringUtils.equals(per.getCheckMethod(), "dataTypeCheck")) {
                Map<String, Object> p_dataTypeTmp = new HashMap<>();
                p_dataTypeTmp.put("dataType", per.getCheckParam());
                p_tmpCheckRule.put(per.getCheckMethod(), p_dataTypeTmp);
            } else if (StringUtils.equals(per.getCheckMethod(), "required")
                || StringUtils.equals(per.getCheckMethod(), "number")) {
                if (StringUtils.equals(per.getCheckParam(), "true")) {
                    p_tmpCheckRule.put(per.getCheckMethod(), true);
                }
            } else if (StringUtils.equals(per.getCheckMethod(), "min")
                    || StringUtils.equals(per.getCheckMethod(), "max")
                    || StringUtils.equals(per.getCheckMethod(), "maxlength")
                    || StringUtils.equals(per.getCheckMethod(), "minlength")) {
                if (!StringUtils.isEmpty(per.getCheckParam())) {
                    p_tmpCheckRule.put(per.getCheckMethod(), Double.valueOf(per.getCheckParam()));
                }
            } else if (StringUtils.equals(per.getCheckMethod(), "checkReg")) {
                Map<String, Object> p_dataTypeTmp = new HashMap<>();
                p_dataTypeTmp.put("reg", per.getCheckParam());
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

        // 数字类型时，右对齐
        for (Map<String, Object> per : p_itemsRet) {
            if (StringUtils.equals((String)per.get("type"), "text")) {
                if (p_numObjects.containsKey(per.get("id"))) {
                    per.put("text-align", "right");
                } else {
                    per.put("text-align", "left");
                }
            }
        }
        // B9泊位数据专用JS追加
        if (StringUtils.equals(x_menuCd, "m1_9")
            || StringUtils.equals(x_menuCd, "m2_9")) {
            List<Map<String, Object>> p_events = new ArrayList<>();
            Map<String, Object> event = new HashMap<>();
            event.put("id", "servicesAvailability");
            event.put("eventType", "change");
            event.put("method", "controlStatusInB9");
            p_events.add(event);
            p_ret.put("events", p_events);
        }
        // B.11区域通告的场合，需要整合子区域返回
        if (StringUtils.equals(x_menuCd, "m1_11")
            || StringUtils.equals(x_menuCd, "m2_11")) {
            List<MenuSubArea> p_subAreasDb = this.getSubAreas(x_menuCd);
            List<Map<String, Object>> p_subAreasRet = new ArrayList<>();
            Map<String, Object> p_subArea = null;
            for (int i = 0; i < p_subAreasDb.size(); i++) {
                MenuSubArea p_tmp = p_subAreasDb.get(i);
                if (StringUtils.equals(p_tmp.getItemId(), "areaShape")) {
                    p_subArea = new HashMap<String, Object>();
                    p_subAreasRet.add(p_subArea);
                }
                p_subArea.put(p_tmp.getItemId(), p_tmp.getItemInitval());
            }
            p_ret.put("subAreaData", p_subAreasRet);

            Map<String, Object> p_subDef = new HashMap<>();
            p_subDef.put("label", "子区域");
            p_subDef.put("modelId", "#myArea");
            p_subDef.put("disabled", true);
            p_ret.put("subArea", p_subDef);
        }

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
    private Menu getMenu(String x_menuCd) {
        return g_mapperMenu.selectByPrimaryKey(x_menuCd);
    }
    private List<MmsiCurrent> getMmisCurrent() {
        Calendar p_cal = Calendar.getInstance();
        p_cal.add(Calendar.HOUR, 0 - Constant.getExtensionConfigInt(Constant.Key.CFG_MMSI_VALID_TIME));
        MmsiCurrentExample p_where = new MmsiCurrentExample();
        p_where.createCriteria().andRTimeGreaterThan(p_cal.getTime()).andUseFlagEqualTo(Constant.Value.CONST_CURRENT_MMSI_USE_FLAG_IN_USE);
        return g_mapperMmsi.selectByExample(p_where);
    }
    private List<MenuSubArea> getSubAreas(String x_menuCd) {
        MenuSubAreaExample p_where = new MenuSubAreaExample();
        p_where.createCriteria().andMCodeEqualTo(x_menuCd);
        p_where.setOrderByClause("sub_area_no, item_dispno");
        return g_mapperMenuSubArea.selectByExample(p_where);
    }
}
