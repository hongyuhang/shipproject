package com.cbdz.sib.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.service.HistoryListService;
import com.github.pagehelper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class HistoryListController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(HistoryListController.class);
    @Autowired
    private HistoryListService g_service;

    @RequestMapping(value = "/historyList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> searchHistory(@RequestBody JSONObject params, HttpServletRequest request) {
        JSONObject p_searchParam = (JSONObject) params.clone();
        // 向Session放置检索条件
        if (StringUtils.equals("1", params.getString("token"))) {
            request.getSession().setAttribute("search_token", params);
        }
        // 构建检索参数
        JSONObject p_ssParam = (JSONObject) request.getSession().getAttribute("search_token");
        String[] p_fields = new String[]{"s_time_fr", "s_time_to", "msg_code", "s_type", "mmsi", "ret_code"};
        for (String per : p_fields) {
            if (StringUtils.equals(per, "msg_code") && StringUtils.equals(p_ssParam.getString(per), "0")) {
                p_searchParam.put(per, "");
            } else {
                p_searchParam.put(per, p_ssParam.getString(per));
            }
        }
        JSONObject result = g_service.getHistList(p_searchParam);
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
