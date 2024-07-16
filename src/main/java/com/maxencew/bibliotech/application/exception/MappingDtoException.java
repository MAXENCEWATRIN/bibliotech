package com.maxencew.bibliotech.application.exception;

public class MappingDtoException extends MappingException {
    public MappingDtoException(String message) {
        super(message);
    }
    public MappingDtoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}