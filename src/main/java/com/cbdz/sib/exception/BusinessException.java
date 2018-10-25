package com.cbdz.sib.exception;

import com.cbdz.sib.exception.errorcode.ErrorCode;

/**
 * 业务异常类。
 *
 * <p>
 * 统一异常层次，便于处理与监控。
 *
 * @author zh.guo
 *
 */
public class BusinessException extends RuntimeException {
    /** serialVersionUID */
    private static final long serialVersionUID = 0L;

    /** 异常编码 */
    protected String code;

    /**
     * @param code 异常编码
     */
    public BusinessException(ErrorCode code) {
        super(code.getMessage());
        this.code = code.getCode();
    }
    /**
     * @param code 异常编码
     * @param message 消息
     */
    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode code, String message) {
        super(code.getMessage() + ":" + message);
        this.code = code.getCode();
    }

    public BusinessException(ErrorCode errorCode, Throwable cause) {
        // super(cause , errorCode.getMessage());
        super(errorCode.getMessage() + ":" + cause.getMessage(), cause);
        this.code = errorCode.getCode();
    }

    public String getCode() {
        return code;
    }

}