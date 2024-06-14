package com.kovalev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kovalev.dto.response.BadValidationResponse;
import com.kovalev.dto.response.ExceptionResponse;
import com.kovalev.exceptions.CreatingException;
import com.kovalev.exceptions.NotFoundException;





@RestControllerAdvice
public class ControllerExceptionHandler {

    public static final String INVALID_FIELD_VALUES = "Invalid field values";
    
    @ExceptionHandler(CreatingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BadValidationResponse entityNotUnique(CreatingException e) {
        return new BadValidationResponse(
                e.getMessage(),
                INVALID_FIELD_VALUES,
                List.of("book or author")
        );
    }
    
    
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BadValidationResponse entityNotFound(NotFoundException e) {
        return new BadValidationResponse(
                e.getMessage(),
                INVALID_FIELD_VALUES,
                List.of("book or author")
        );
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse all(Exception e) {
        return new ExceptionResponse(
                "Server error",
                concatMessages(e)
        );
    }
    
    private String concatMessages(Throwable e) {
        StringBuilder message = new StringBuilder(e.getMessage());
        while ((e = e.getCause()) != null) {
            if (e.getMessage() != null) message.append(". Cause: ").append(e.getMessage());
        }
        return message.toString();
    }
}
