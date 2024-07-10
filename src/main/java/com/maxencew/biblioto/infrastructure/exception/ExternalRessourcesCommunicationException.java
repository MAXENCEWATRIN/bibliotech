package com.maxencew.biblioto.infrastructure.exception;

public class ExternalRessourcesCommunicationException extends RuntimeException {
    public ExternalRessourcesCommunicationException(String message) {
        super(message);
    }

    public ExternalRessourcesCommunicationException(String message, Throwable throwable) {
        super(message, throwable);
    }

}