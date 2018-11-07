package com.cbdz.sib.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.service.ReceiveMmsiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceiveShipInfoController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ReceiveShipInfoController.class);
    @Autowired
    private ReceiveMmsiService g_service;

    @RequestMapping(value = "/api/receiveShipInfo", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject receiveMmsi(@RequestBody JSONObject params) {
        logger.debug("ReceiveShipInfoController.receiveMmsi() Param= " + JSON.toJSONString(params, true));
        JSONObject p_ret = g_service.receiveMmsi(params);

        logger.info("ReceiveShipInfoController.receiveMmsi() return value= " + JSON.toJSONString(p_ret, true));
        return p_ret;
    }
}
