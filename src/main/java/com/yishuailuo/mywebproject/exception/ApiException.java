package com.yishuailuo.mywebproject.exception;

/**
 * Created by luoyishuai on 17/6/4.
 */
public class ApiException extends RuntimeException {

    protected Long errorCode;
    protected Object data;

    public ApiException(Long errorCode, String message, Object data, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.data = data;
    }

    public ApiException(Long errorCode, String message, Object data) {
        this(errorCode, message, data, null);
    }

    public ApiException(Long errorCode, String message) {
        this(errorCode, message, null, null);
    }

    public ApiException(String message, Throwable cause) {
        this(null, message, null, cause);
    }

    public ApiException() {
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
