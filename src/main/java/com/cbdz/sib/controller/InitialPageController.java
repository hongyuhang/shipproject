package com.cbdz.sib.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class InitialPageController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(InitialPageController.class);

    @RequestMapping(value = "/initialInfo", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getInitialInfo(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> items = new ArrayList();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("type", "text");
        item1.put("label", "经度:");
        item1.put("id", "txtItm1");
        item1.put("placeholder", "非空，最小长度2");
        item1.put("val", "109.66");
        Map<String, Object> item2 = new HashMap<>();
        item2.put("type", "text");
        item2.put("label", "文本2:");
        item2.put("id", "txtItm2");
        item2.put("placeholder", "非空，最大长度5");
        Map<String, Object> item3 = new HashMap<>();
        item3.put("type", "text");
        item3.put("label", "文本3:");
        item3.put("id", "txtItm3");
        item3.put("placeholder", "数字");
        Map<String, Object> item4 = new HashMap<>();
        item4.put("type", "text");
        item4.put("label", "文本4:");
        item4.put("id", "txtItm4");
        item4.put("placeholder", "正则表达式电话号码");
        Map<String, Object> item5 = new HashMap<>();
        item5.put("type", "popupSelect");
        item5.put("label", "纬度:");
        item5.put("id", "popselItm");
        item5.put("placeholder", "请选择纬度");
        item5.put("modelId", "#myModal");
        item5.put("val", "Larry");
        item5.put("disabled", true);
        Map<String, Object> item6 = new HashMap<>();
        item6.put("type", "select");
        item6.put("label", "位置精度:");
        item6.put("id", "selItm");
        item6.put("disabled", true);
        List<Map<String, String>> options = new ArrayList<>();
        Map<String, String> opt1 = new HashMap<>();
        opt1.put("","");
        Map<String, String> opt2 = new HashMap<>();
        opt2.put("0","低");
        Map<String, String> opt3 = new HashMap<>();
        opt3.put("1","高");
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        item6.put("vals", options);
        Map<String, Object> item7 = new HashMap<>();
        item7.put("type", "selectPicker");
        item7.put("label", "模糊查询下拉:");
        item7.put("id", "selpickerItm");
        item7.put("val", "1");
        options = new ArrayList<>();
        opt1 = new HashMap<>();
        opt1.put("","");
        opt2 = new HashMap<>();
        opt2.put("0","低123123");
        opt3 = new HashMap<>();
        opt3.put("1","高567567");
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        item7.put("vals", options);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        result.put("items", items);

        Map<String, Object> subArea = new HashMap<>();
        subArea.put("label", "子区域:");
        subArea.put("modelId", "#myArea");
        subArea.put("disabled", true);
        result.put("subArea", subArea);

        Map<String, Object> checkRules = new HashMap<>();
        Map<String, Object> txtItm1 = new HashMap<>();
        txtItm1.put("required", true);
        txtItm1.put("minlength", 2);
        checkRules.put("txtItm1", txtItm1);
        Map<String, Object> txtItm2 = new HashMap<>();
        txtItm2.put("required", true);
        txtItm2.put("maxlength", 5);
        checkRules.put("txtItm2", txtItm2);
        Map<String, Object> txtItm3 = new HashMap<>();
        txtItm3.put("number", true);
        checkRules.put("txtItm3", txtItm3);
        Map<String, Object> txtItm4 = new HashMap<>();
        Map<String, Object> reg = new HashMap<>();
        reg.put("reg", "^(((13[0-9]{1})|(15[0-9]{1}))+\\d{8})$");
        txtItm4.put("checkReg", reg);
        checkRules.put("txtItm4", txtItm4);
        result.put("checkRules", checkRules);

        Map<String, Object> checkMessages = new HashMap<>();
        txtItm1 = new HashMap<>();
        txtItm1.put("required", "");
        txtItm1.put("minlength", "最少录入2位");
        checkMessages.put("txtItm1", txtItm1);
        txtItm2 = new HashMap<>();
        txtItm2.put("required", "");
        txtItm2.put("maxlength", "最多录入5位");
        checkMessages.put("txtItm2", txtItm2);
        txtItm3 = new HashMap<>();
        txtItm3.put("number", "请录入数字");
        checkMessages.put("txtItm3", txtItm3);
        txtItm4 = new HashMap<>();
        txtItm4.put("checkReg", "请录入电话号码");
        checkMessages.put("txtItm4", txtItm4);
        result.put("checkMessages", checkMessages);

        List<Map<String, Object>> events = new ArrayList<>();
        Map<String, Object> event = new HashMap<>();
        event.put("id", "txtItm1");
        event.put("eventType", "blur");
        event.put("method", "itemTxtLostFouse");
        events.add(event);
        result.put("events", events);

        logger.info(JSON.toJSONString(result, true));

        return this.success(result);
    }
}
