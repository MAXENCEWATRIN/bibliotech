package com.maxencew.biblioto.domain.ports.spi;

import com.maxencew.biblioto.domain.model.Book;

import java.util.Optional;

public interface ExternalIsbnApiPort {
    Optional<Book> fetchBookDetails(Long isbnId);
}
