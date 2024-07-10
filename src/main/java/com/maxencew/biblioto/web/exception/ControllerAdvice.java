package com.maxencew.biblioto.web.exception;

import com.maxencew.biblioto.application.exception.BusinessException;
import com.maxencew.biblioto.application.exception.ValidationException;
import com.maxencew.biblioto.application.response.BibliotoHttpResponse;
import com.maxencew.biblioto.infrastructure.exception.ExternalRessourcesCommunicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BibliotoHttpResponse<String>> handleBusinessException(BusinessException ex, WebRequest request) {
        BibliotoHttpResponse<String> response = BibliotoHttpResponse.error(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<BibliotoHttpResponse<String>> handleValidationException(ValidationException ex, WebRequest request) {
        BibliotoHttpResponse<String> response = BibliotoHttpResponse.error(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExternalRessourcesCommunicationException.class)
    public ResponseEntity<BibliotoHttpResponse<String>> handleValidationException(ExternalRessourcesCommunicationException ex, WebRequest request) {
        BibliotoHttpResponse<String> response = BibliotoHttpResponse.error(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BibliotoHttpResponse<String>> handleGlobalException(Exception ex, WebRequest request) {
        BibliotoHttpResponse<String> response = BibliotoHttpResponse.error("Internal Server Error");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
