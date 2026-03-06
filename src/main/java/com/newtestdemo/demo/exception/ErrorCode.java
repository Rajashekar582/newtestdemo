package com.newtestdemo.demo.exception;

public enum ErrorCode {
    EMPLOYEE_NOT_FOUND("EMPLOYEE_NOT_FOUND", "Employee not found"),
    INVALID_REQUEST("INVALID_REQUEST", "Invalid request"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "Internal server error");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
