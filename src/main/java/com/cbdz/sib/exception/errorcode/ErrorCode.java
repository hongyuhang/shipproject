package com.cbdz.sib.exception.errorcode;

public enum ErrorCode {
    // 系统异常
    UNKNOWN_ERROR("-1", "系统内部异常，请稍后再试");

    private String code;
    private String message;

    private ErrorCode(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + this.code + "]" + this.message;
    }
}
