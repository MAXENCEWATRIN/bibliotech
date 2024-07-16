package com.maxencew.biblioto.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BibliotechHttpResponse<T> {
    private boolean success;
    private T data;
    private String error;

    public static <T> BibliotechHttpResponse<T> success(T data) {
        return new BibliotechHttpResponse<>(true, data, null);
    }

    public static <T> BibliotechHttpResponse<T> error(String error, T data) {
        return new BibliotechHttpResponse<>(false, data, error);
    }

    public static <T> BibliotechHttpResponse<T> validationExpectation(T data, String error) {
        return new BibliotechHttpResponse<>(false, data, error);
    }
}
