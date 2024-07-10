package com.maxencew.biblioto.infrastructure.exception;

public class AppPersistenceException extends RuntimeException {
    public AppPersistenceException(String message) {
        super(message);
    }

    public AppPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }


}