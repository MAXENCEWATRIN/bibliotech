package com.maxencew.bibliotech.infrastructure.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxencew.bibliotech.domain.model.Book;
import com.maxencew.bibliotech.domain.ports.api.BookConsumer;
import com.maxencew.bibliotech.infrastructure.dto.BookConsumerMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class KafkaConsumer {

    @Autowired
    private BookConsumer bookConsumer;

    @KafkaListener(topics = "topic-bibliotech-books", groupId = "bibliotech-group")
    public void consume(String isbnIdJson) throws JsonProcessingException {
        LOGGER.info("Réception d'un livre par Kafka.");
        final BookConsumerMessage isbnId = new ObjectMapper().readValue(isbnIdJson, BookConsumerMessage.class);
        bookConsumer.consume(isbnId.getIsbnId());
    }
}
