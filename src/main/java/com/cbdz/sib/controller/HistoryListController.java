package com.cbdz.sib.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.service.HistoryListService;
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
    private HistoryListService g_service;

    @RequestMapping(value = "/historyList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchHistory(@RequestParam JSONObject params) {
        JSONObject result = g_service.getHistList(params);
        logger.info(JSON.toJSONString(result, true));

        return this.success(result);
    }
    @RequestMapping(value = "/historyInitList", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getInitialInfo() {
        Map<String, Object> result = g_service.getHistList(null);
        logger.info(JSON.toJSONString(result, true));

        return this.success(result);
    }
}
