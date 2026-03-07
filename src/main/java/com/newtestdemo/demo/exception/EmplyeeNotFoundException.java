package com.newtestdemo.demo.exception;

public class EmplyeeNotFoundException extends RuntimeException {

    private ErrorCode code;
    private String httpRequest;

    public EmplyeeNotFoundException(String message) {
        super(message);
    }

    public EmplyeeNotFoundException(ErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public void setHttpRequest(String httpRequest) {
        this.httpRequest = httpRequest;
    }
}
