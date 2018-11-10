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


    @RequestMapping(value = "/tableInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getTableInfo(@RequestBody Map<String, Object>map) {
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        Item engine1 = new Item();
        engine1.setValue("aaaaa");
        engine1.setLinkFlg(true);
        engine1.setLinkField("engine");
        engine1.setUrl("www.baidu.com");
        engine1.setLinkParamValue("param1");

        map1.put("engine", engine1);

        Item browser = new Item();
        browser.setValue("bbbbb");

        map1.put("browser", browser);

        Item platform = new Item();
        platform.setValue(789);

        map1.put("platform", platform);

        Item version = new Item();
        version.setValue("ddddd");

        map1.put("version", version);

        Item grade = new Item();
        grade.setValue("eeeee");

        map1.put("grade", grade);

        Map<String, Object> map2 = new HashMap<>();

        engine1.setValue("22222");
        engine1.setLinkFlg(true);
        engine1.setLinkField("engine");
        engine1.setUrl("www.baidu.com");
        engine1.setLinkParamValue("param1");

        map2.put("engine", engine1);

        browser.setValue("333333");

        map2.put("browser", browser);

        platform.setValue(654654);

        map2.put("platform", platform);

        version.setValue("ddddd");

        map2.put("version", version);

        grade.setValue("eeeee");

        map2.put("grade", grade);

        list.add(map1);
        list.add(map2);

        result.put("data", list);
        result.put("total", "2");

        List<Map<String, String>> columnList = new ArrayList<>();
        Map<String, String> column1info = new HashMap<>();
        column1info.put("data", "engine");
        column1info.put("title", "引擎");
        columnList.add(column1info);

        Map<String, String> column2info = new HashMap<>();
        column2info.put("data", "browser");
        column2info.put("title", "浏览器");
        columnList.add(column2info);

        Map<String, String> column3info = new HashMap<>();
        column3info.put("data", "platform");
        column3info.put("title", "平台");
        columnList.add(column3info);

        Map<String, String> column4info = new HashMap<>();
        column4info.put("data", "version");
        column4info.put("title", "版本");
        columnList.add(column4info);

        Map<String, String> column5info = new HashMap<>();
        column5info.put("data", "version");
        column5info.put("title", "版本");
        columnList.add(column5info);

        result.put("columns", columnList);
        logger.info(JSON.toJSONString(result, true));

        return this.success(result);
    }
    class Item {
        Object value;
        boolean linkFlg;
        String linkField;
        String url;
        String linkParamValue;

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public boolean isLinkFlg() {
            return linkFlg;
        }

        public void setLinkFlg(boolean linkFlg) {
            this.linkFlg = linkFlg;
        }

        public String getLinkField() {
            return linkField;
        }

        public void setLinkField(String linkField) {
            this.linkField = linkField;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getLinkParamValue() {
            return linkParamValue;
        }

        public void setLinkParamValue(String linkParamValue) {
            this.linkParamValue = linkParamValue;
        }
    }
}
