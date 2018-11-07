package com.cbdz.sib.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.service.PageItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HistoryListController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(HistoryListController.class);
    @Autowired
    private PageItemService g_servicePageItem;

    @RequestMapping(value = "/historyList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getInitialInfo(@RequestParam JSONObject params) {
//        Map<String, Object> result = g_servicePageItem.getPageItemByMenuCd(menuCode);
//        logger.info(JSON.toJSONString(result, true));

//        return this.success(result);
        return null;
    }
}
