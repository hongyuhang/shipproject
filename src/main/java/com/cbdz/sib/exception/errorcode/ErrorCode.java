package com.cbdz.sib.exception.errorcode;

import com.alibaba.fastjson.JSONObject;

public enum ErrorCode {
    // 系统异常
    UNKNOWN_ERROR("-1", "系统内部异常，请稍后再试"),
    SUCCESS("200", "处理成功"),
    HLHT_TOKEN_ERR("411", "取得互联互通平台TOKEN失败"),
    HLHT_SERVER_URL_ERR("412", "取得VDES服务地址失败"),
    HLHT_SERVER_INVOKE_ERR("413", "调用VDES服务失败"),
    RECEIVE_DATA_ERROR("414", "传入数据格式错误");

    private String code;
    private String message;
    private JSONObject json;

    private ErrorCode(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
        json = new JSONObject();
        json.put("code", code);
        json.put("message", message);
    }
    public JSONObject getJson() {
        return json;
    }
    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + this.code + "]" + this.message;
    }
}
