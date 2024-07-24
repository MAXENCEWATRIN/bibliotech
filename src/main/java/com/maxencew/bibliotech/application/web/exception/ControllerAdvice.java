package com.maxencew.bibliotech.application.web.exception;

import com.maxencew.bibliotech.application.exception.BusinessException;
import com.maxencew.bibliotech.application.exception.MappingDtoException;
import com.maxencew.bibliotech.application.exception.MappingException;
import com.maxencew.bibliotech.application.exception.ValidationException;
import com.maxencew.bibliotech.application.response.BibliotechHttpResponse;
import com.maxencew.bibliotech.infrastructure.exception.AppPersistenceException;
import com.maxencew.bibliotech.infrastructure.exception.ExternalRessourcesCommunicationException;
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
    public ResponseEntity<BibliotechHttpResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        BibliotechHttpResponse<Map<String, String>> response = BibliotechHttpResponse.validationExpectation(errors, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppPersistenceException.class)
    public ResponseEntity<BibliotechHttpResponse<String>> handlePersistenceException(AppPersistenceException ex, WebRequest request) {
        BibliotechHttpResponse<String> response = BibliotechHttpResponse.error("An exception occurred in the repository layer : " + ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BibliotechHttpResponse<String>> handleBusinessException(BusinessException ex, WebRequest request) {
        BibliotechHttpResponse<String> response = BibliotechHttpResponse.error(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<BibliotechHttpResponse<String>> handleValidationException(ValidationException ex, WebRequest request) {
        BibliotechHttpResponse<String> response = BibliotechHttpResponse.error(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MappingException.class)
    public ResponseEntity<BibliotechHttpResponse<String>> handleMappingException(MappingException ex, WebRequest request) {
        BibliotechHttpResponse<String> response;
        if (ex instanceof MappingDtoException) {
            response =
                    BibliotechHttpResponse.error(String.format("An exception occurred in the mapper DTO layer : %s", ex.getMessage()),
                            request.getDescription(false));
        } else {
            response =
                    BibliotechHttpResponse.error(String.format("An exception occurred in the mapper Entity layer : %s", ex.getMessage()),
                            request.getDescription(false));
        }

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExternalRessourcesCommunicationException.class)
    public ResponseEntity<BibliotechHttpResponse<String>> handleExternalHttpCallException(ExternalRessourcesCommunicationException ex, WebRequest request) {
        BibliotechHttpResponse<String> response = BibliotechHttpResponse.error(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BibliotechHttpResponse<String>> handleGlobalException(Exception ex, WebRequest request) {
        BibliotechHttpResponse<String> response = BibliotechHttpResponse.error("Internal Server Error : " + ex,
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
