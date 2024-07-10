package com.maxencew.biblioto.application.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
    public BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }
}