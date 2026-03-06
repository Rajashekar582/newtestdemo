package com.newtestdemo.demo.exception;

public class EmplyeeNotFound extends RuntimeException {

    private ErrorCode code;
    private String httpRequest;

    public EmplyeeNotFound(String message) {
        super(message);
    }

    public EmplyeeNotFound(ErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public void setHttpRequest(String httpRequest) {
        this.httpRequest = httpRequest;
    }
}
