package com.maxencew.bibliotech.application.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
    public ValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}