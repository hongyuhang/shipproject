package com.cbdz.sib.service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cbdz.sib.dao.MenuItemCheckMapper;
import com.cbdz.sib.dao.MenuItemMapper;
import com.cbdz.sib.dao.MenuMapper;
import com.cbdz.sib.model.*;
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
public class MenuItemService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MenuMapper g_mapperMenu;

    @Transactional
    public List<Map<String, Object>> getMenuItem() {
        List<Map<String, Object>> p_ret = new ArrayList<Map<String, Object>>();
        Map<String, Object> p_menu1 = null;
        List<Map<String, Object>> p_menu2 = null;

        List<Menu> p_itemsDb = this.getMenuData();

        for (Menu per : p_itemsDb) {
            if (per.getmLevel() == 1) {
                p_menu1 = new HashMap<String, Object>();
                p_menu1.put("menuCode", per.getmCode());
                p_menu1.put("menuName", per.getmName());

                p_ret.add(p_menu1);
                p_menu2 = new ArrayList<Map<String, Object>>();
                p_menu1.put("subMenu", p_menu2);
            } else if (per.getmLevel() == 2) {
                Map<String, Object> p_tmpMenu2Data = new HashMap<String, Object>();
                p_tmpMenu2Data.put("menuCode", per.getmCode());
                p_tmpMenu2Data.put("menuName", per.getmName());
                p_tmpMenu2Data.put("url", per.getmUrl());
            }
        }
        logger.info(JSON.toJSONString(p_ret, true));

        return p_ret;
    }

    private List<Menu> getMenuData() {
        MenuExample p_where = new MenuExample();
        p_where.setOrderByClause("m_dispno");
        return g_mapperMenu.selectByExample(p_where);
    }
}
