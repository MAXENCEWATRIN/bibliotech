package com.maxencew.biblioto.infrastructure.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ExternalApiConfiguration {

    @Value("${external.api.isbn.url}")
    private String apiIsbnUrl;

    @Value("${external.api.isbn.key}")
    private String apiIsbnKey;

    @Value("${external.api.openLibrary.login-api.url}")
    private String openLibraryLoginUrl;

    @Value("${external.api.openLibrary.books-api.url}")
    private String openLibraryBooksUrl;

    @Value("${external.api.openLibrary.covers-api.url}")
    private String openLibraryCoversUrl;

    @Value("${external.api.openLibrary.login}")
    private String openLibraryLogin;

    @Value("${external.api.openLibrary.key}")
    private String openLibraryKey;
}
