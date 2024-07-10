package com.maxencew.biblioto.application.exception;

public class MappingEntityException extends MappingException {
    public MappingEntityException(String message) {
        super(message);
    }
    public MappingEntityException(String message, Throwable throwable) {
        super(message, throwable);
    }
}