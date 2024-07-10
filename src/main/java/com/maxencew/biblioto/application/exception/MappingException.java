package com.maxencew.biblioto.application.exception;

public class MappingException extends RuntimeException {
    public MappingException(String message) {
        super(message);
    }
    public MappingException(String message, Throwable throwable) {
        super(message, throwable);
    }
}