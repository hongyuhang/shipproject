package com.cbdz.sib.controller;

import com.alibaba.fastjson.JSON;
import com.cbdz.sib.service.PageItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InitialPageController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(InitialPageController.class);
    @Autowired
    private PageItemService g_servicePageItem;

    @RequestMapping(value = "/initialInfo", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getInitialInfo(@RequestParam String menuCode) {
        Map<String, Object> result = g_servicePageItem.getPageItemByMenuCd(menuCode);
        logger.info(JSON.toJSONString(result, true));

        return this.success(result);
    }
}
