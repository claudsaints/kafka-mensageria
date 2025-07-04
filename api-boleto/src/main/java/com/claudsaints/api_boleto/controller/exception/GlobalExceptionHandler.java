package com.claudsaints.api_boleto.controller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Object> applicationException(ApplicationException e, WebRequest request){
        var reponse = ErrorResponse.builder()
                .error(e.getMessage())
                .codigo(HttpStatus.BAD_REQUEST.value())
                .path(request.getDescription(false))
                .timestamp(new Date()).build()
                ;

        return new ResponseEntity<>(reponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request){
        var errors = e.getFieldErrors().stream().map(item -> item.getField() + " " + item.getDefaultMessage())
                .collect(Collectors.joining());

        var reponse = ErrorResponse.builder()
                .error(errors)
                .codigo(HttpStatus.BAD_REQUEST.value())
                .path(request.getDescription(false))
                .timestamp(new Date()).build()
                ;

        return new ResponseEntity<>(reponse,HttpStatus.BAD_REQUEST);
    }
}
