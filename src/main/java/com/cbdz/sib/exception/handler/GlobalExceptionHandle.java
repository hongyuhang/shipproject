package com.cbdz.sib.exception.handler;

import com.cbdz.sib.controller.BaseController;
import com.cbdz.sib.exception.BusinessException;
import com.cbdz.sib.exception.errorcode.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 对异常进行全局统一管理句柄
 * @author zh.guo
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    protected static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandle.class);

    /**
     * 管理异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorInfo> unknownException(Exception e) {
        LOG.error("Internal server error: " + e.getLocalizedMessage(), e);
        return getErrorResponseEntity(new BusinessException(ErrorCode.UNKNOWN_ERROR, e.getCause()));
    }

    /**
     * 管理已知业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseEntity<ErrorInfo> businessException(BusinessException ex) {
        return getErrorResponseEntity(ex);
    }

    private ResponseEntity<ErrorInfo> getErrorResponseEntity(BusinessException bex) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setCode(bex.getCode());
        errorInfo.setMessage(bex.getMessage());
        errorInfo.setTrace(this.getTrace(bex.getStackTrace()));
        ResponseEntity<ErrorInfo> responseEntity = ResponseEntity.badRequest()
                .header("X-Api-Version", BaseController.API_VERSION).body(errorInfo);
        return responseEntity;
    }

    private String getTrace(StackTraceElement[] stackTraceElement) {
        StringBuilder traceStr = new StringBuilder();
        for (StackTraceElement trace : stackTraceElement) {
            traceStr.append(trace.toString() + "\n\r");
        }
        return traceStr.toString();
    }

    public class ErrorInfo {
        private String code;

        private String message;

        private String trace;

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

        public String getTrace() {
            return trace;
        }

        public void setTrace(String trace) {
            this.trace = trace;
        }

    }
}