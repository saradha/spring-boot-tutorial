package com.saradha.controller.exception.handling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoProductFoundException.class)
    public final ResponseEntity<ApiExceptionResponse> handleNoProductsFoundException(NoProductFoundException ex, WebRequest request) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.NOT_FOUND);

    }

}
