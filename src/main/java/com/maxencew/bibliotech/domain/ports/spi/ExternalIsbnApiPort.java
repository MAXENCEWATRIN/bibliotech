package com.maxencew.bibliotech.domain.ports.spi;

import com.maxencew.bibliotech.domain.model.Book;

import java.util.Optional;

public interface ExternalIsbnApiPort {
    Optional<Book> fetchBookDetails(Long isbnId);
}
