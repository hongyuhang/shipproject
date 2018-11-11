package com.cbdz.sib.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础Controller类
 *
 * @author zh.guo
 *
 */
public abstract class BaseController {

    // TODO：
    public static final String WEB_UI_INDEX_PAGE_ROUTE = "/dashboard";

    public static final String API_VERSION = "1";

    private Map<String, Object> getResponseEntityBodyMap(String code, String message) {
        Map<String, Object> responseEntityBodyMap = new HashMap<String, Object>();
        responseEntityBodyMap.put("code", code);
        responseEntityBodyMap.put("message", message);
        return responseEntityBodyMap;
    }

    protected <T> ResponseEntity<Map<String, Object>> success(T data, String message) {
        Map<String, Object> responseEntityBodyMap = this.getResponseEntityBodyMap("200", message);
        if (data != null) {
            if (data.getClass().equals(JSONObject.class)) {
                String p_tmp = JSONObject.toJSONStringWithDateFormat(data, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
                responseEntityBodyMap.put("data", JSONObject.parseObject(p_tmp));
            } else {
                responseEntityBodyMap.put("data", data);
            }
        }
        ResponseEntity<Map<String, Object>> successResponse = this.setApiVersion(ResponseEntity.ok())
                .body(responseEntityBodyMap);
        return successResponse;
    }

    protected <T> ResponseEntity<Map<String, Object>> confirm(T data, String message) {
        Map<String, Object> responseEntityBodyMap = this.getResponseEntityBodyMap("202", message);
        if (data != null) {
            responseEntityBodyMap.put("data", data);
        }
        ResponseEntity<Map<String, Object>> successResponse = this.setApiVersion(ResponseEntity.ok())
                .body(responseEntityBodyMap);
        return successResponse;
    }

    protected <T> ResponseEntity<Map<String, Object>> success(T data) {
        return this.success(data, "");
    }

    protected ResponseEntity<Map<String, Object>> success(String message) {
        return this.success(null, message);
    }

    protected ResponseEntity<Map<String, Object>> success() {
        return this.success(null, "");
    }

    private ResponseEntity.BodyBuilder setApiVersion(ResponseEntity.BodyBuilder builder) {
        builder.header("X-Api-Version", API_VERSION);
        return builder;
    }
    
    protected <T> ResponseEntity<Map<String, Object>> fail(T data, String message) {
        Map<String, Object> responseEntityBodyMap = this.getResponseEntityBodyMap("400", message);
        if (data != null) {
            responseEntityBodyMap.put("data", data);
        }
        ResponseEntity<Map<String, Object>> failResponse = this.setApiVersion(ResponseEntity.ok())
                .body(responseEntityBodyMap);
        return failResponse;
    }

}