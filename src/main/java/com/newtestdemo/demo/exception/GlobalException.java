package com.newtestdemo.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.http.HttpRequest;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(EmplyeeNotFound.class)
    public ResponseEntity<?> handleEmplyeeNotFound(EmplyeeNotFound ex, WebRequest request){
            ex.setHttpRequest(request.getDescription(true));
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);  }
}
