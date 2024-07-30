package com.maxencew.bibliotech.domain.service.adapter;

import com.maxencew.bibliotech.domain.ports.api.BookConsumer;
import com.maxencew.bibliotech.domain.ports.api.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class BookConsumerAdapter implements BookConsumer {

    private BookService bookServiceAdapter;

    @Override
    public void consume(String isbnId) {
        bookServiceAdapter.getByIsbnId(Long.valueOf(isbnId));
    }
}
