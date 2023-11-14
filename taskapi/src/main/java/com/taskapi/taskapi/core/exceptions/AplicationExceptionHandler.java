package com.taskapi.taskapi.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class AplicationExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handleExeption(Exception e){
        log.info("teste");
        return null; 
    }
}
