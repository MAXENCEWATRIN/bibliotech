package com.maxencew.bibliotech.domain.ports.api;

import com.maxencew.bibliotech.domain.model.Book;

public interface BookConsumer {

    void consume(String isbnId);
}
