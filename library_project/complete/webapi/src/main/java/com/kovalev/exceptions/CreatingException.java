package com.kovalev.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CreatingException extends RuntimeException{
   
    private final HttpStatus status;
    
    public CreatingException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
    
    public CreatingException(String message, HttpStatus status, Throwable e) {
        super(message);
        this.status = status;
    }
}
