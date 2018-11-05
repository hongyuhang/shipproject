package com.cbdz.sib.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.service.SendDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SendDataController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SendDataController.class);
    @Autowired
    private SendDataService g_service;

    @RequestMapping(value = "/sendData", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> sendData(@RequestParam String x_menuCd, @RequestBody JSONObject x_data) {
        JSONObject p_ret = g_service.sendData(x_menuCd, x_data);

        logger.info("SendDataController return value= " + JSON.toJSONString(p_ret, true));
        if (StringUtils.equals(p_ret.getString(""), "200")) {
            return this.success(p_ret);
        } else {
            return super.fail(p_ret, p_ret.getString("rst_message"));
        }

    }
}
