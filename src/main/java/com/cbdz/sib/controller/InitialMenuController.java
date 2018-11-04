package com.cbdz.sib.controller;

import com.alibaba.fastjson.JSON;
import com.cbdz.sib.service.MenuItemService;
import com.cbdz.sib.service.PageItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InitialMenuController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(InitialMenuController.class);
    @Autowired
    private MenuItemService g_serviceMenuItem;

    @RequestMapping(value = "/initialMenu", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getInitialInfo(HttpServletRequest request) {
        List<Map<String, Object>> p_ret = g_serviceMenuItem.getMenuItem();
        logger.info(JSON.toJSONString(p_ret, true));

        return this.success(p_ret);
    }
}
