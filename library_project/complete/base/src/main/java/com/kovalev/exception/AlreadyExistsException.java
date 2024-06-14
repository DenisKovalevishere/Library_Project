package com.kovalev.exception;

import lombok.Getter;

@Getter
public class AlreadyExistsException extends RuntimeException{
    
    private final String clazz;
    
    public AlreadyExistsException(String message, String clazz) {
        super(message);
        this.clazz = clazz;
    }
}
