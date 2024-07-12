package com.maxencew.biblioto.application.web.exception;

import com.maxencew.biblioto.application.exception.BusinessException;
import com.maxencew.biblioto.application.exception.MappingDtoException;
import com.maxencew.biblioto.application.exception.MappingException;
import com.maxencew.biblioto.application.exception.ValidationException;
import com.maxencew.biblioto.application.response.BibliotoHttpResponse;
import com.maxencew.biblioto.infrastructure.exception.AppPersistenceException;
import com.maxencew.biblioto.infrastructure.exception.ExternalRessourcesCommunicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BibliotoHttpResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        BibliotoHttpResponse<Map<String, String>> response = BibliotoHttpResponse.validationExpectation(errors, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppPersistenceException.class)
    public ResponseEntity<BibliotoHttpResponse<String>> handlePersistenceException(AppPersistenceException ex, WebRequest request) {
        BibliotoHttpResponse<String> response = BibliotoHttpResponse.error("An exception occurred in the repository layer : " + ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BibliotoHttpResponse<String>> handleBusinessException(BusinessException ex, WebRequest request) {
        BibliotoHttpResponse<String> response = BibliotoHttpResponse.error(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<BibliotoHttpResponse<String>> handleValidationException(ValidationException ex, WebRequest request) {
        BibliotoHttpResponse<String> response = BibliotoHttpResponse.error(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MappingException.class)
    public ResponseEntity<BibliotoHttpResponse<String>> handleMappingException(MappingException ex, WebRequest request) {
        BibliotoHttpResponse<String> response;
        if (ex instanceof MappingDtoException) {
            response =
                    BibliotoHttpResponse.error(String.format("An exception occurred in the mapper DTO layer : %s", ex.getMessage()),
                            request.getDescription(false));
        } else {
            response =
                    BibliotoHttpResponse.error(String.format("An exception occurred in the mapper Entity layer : %s", ex.getMessage()),
                            request.getDescription(false));
        }

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExternalRessourcesCommunicationException.class)
    public ResponseEntity<BibliotoHttpResponse<String>> handleExternalHttpCallException(ExternalRessourcesCommunicationException ex, WebRequest request) {
        BibliotoHttpResponse<String> response = BibliotoHttpResponse.error(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BibliotoHttpResponse<String>> handleGlobalException(Exception ex, WebRequest request) {
        BibliotoHttpResponse<String> response = BibliotoHttpResponse.error("Internal Server Error : " + ex,
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
