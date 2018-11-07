package com.cbdz.sib.controller;

import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.exception.errorcode.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestSimulateVdesController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(TestSimulateVdesController.class);

    @RequestMapping(value = "/api/message/addressed", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject sendData(@RequestBody JSONObject x_data) {
        return ErrorCode.SUCCESS.getJson();
    }
}
