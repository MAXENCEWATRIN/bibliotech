package com.maxencew.bibliotech.domain.ports.api;

import com.maxencew.bibliotech.infrastructure.dto.BookConsumerMessage;

public interface BookProducer {

    BookConsumerMessage handleBook(BookConsumerMessage bookConsumerMessage);
    void sendToKafka(BookConsumerMessage bookConsumerMessage);
}
