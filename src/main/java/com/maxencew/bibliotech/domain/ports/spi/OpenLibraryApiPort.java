package com.maxencew.bibliotech.domain.ports.spi;

import com.maxencew.bibliotech.domain.model.Book;

import java.util.Optional;

public interface OpenLibraryApiPort {
    String requestAccessToken();
    Optional<Book> retrieveBookCover(Long isbnId);
    Optional<Book> retrieveBookInformation(Long isbnId);
}
