package com.maxencew.biblioto.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BibliotoHttpResponse<T> {
    private boolean success;
    private T data;
    private String error;

    public static <T> BibliotoHttpResponse<T> success(T data) {
        return new BibliotoHttpResponse<>(true, data, null);
    }

    public static <T> BibliotoHttpResponse<T> error(String error, T data) {
        return new BibliotoHttpResponse<>(false, data, error);
    }

    public static <T> BibliotoHttpResponse<T> validationExpectation(T data, String error) {
        return new BibliotoHttpResponse<>(false, data, error);
    }
}
