package com.ts.labs.controllers;

import com.ts.labs.commons.Response;
import com.ts.labs.exceptions.NoSuchStudentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = NoSuchStudentException.class)
    public ResponseEntity<Object> handleError(Exception ex, WebRequest request){
        return handleExceptionInternal(ex,new Response(ex.getMessage()),new HttpHeaders(), HttpStatus.NOT_FOUND,request);
    }
}
