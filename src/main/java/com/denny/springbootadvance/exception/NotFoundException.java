package com.denny.springbootadvance.exception;

public class NotFoundException extends RuntimeException {
    private Long errorCode;
    private String errorMsg;

    public NotFoundException() {
    }

    public NotFoundException(Long errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
