package com.maxencew.biblioto.infrastructure.exception;

public class PersistenceException extends RuntimeException {
    public PersistenceException(String message) {
        super(message);
    }

}