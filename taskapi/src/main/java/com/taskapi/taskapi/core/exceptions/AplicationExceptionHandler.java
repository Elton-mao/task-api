package com.taskapi.taskapi.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class AplicationExceptionHandler extends ResponseEntityExceptionHandler{
    
    
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<DefaultError> handleExeption(Exception e){
        log.info(e.getMessage());
        DefaultError error = new DefaultError(HttpStatus.NOT_FOUND.value(),e.getMessage());       
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    

      @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<DefaultError> handleExeptionEntityNotFoundException(Exception e){
        log.info(e.getMessage());
        DefaultError error = new DefaultError(HttpStatus.NOT_FOUND.value(),e.getMessage());       
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
