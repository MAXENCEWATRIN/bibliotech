package com.maxencew.bibliotech.domain.service.adapter;

import com.maxencew.bibliotech.domain.ports.api.BookProducer;
import com.maxencew.bibliotech.infrastructure.dto.BookConsumerMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@AllArgsConstructor
@Slf4j
public class BookProducerAdapter implements BookProducer {

    private KafkaTemplate<String, Long> kafkaTemplate;

    @Override
    public BookConsumerMessage handleBook(BookConsumerMessage bookConsumerMessage) {
        sendToKafka(bookConsumerMessage);
        LOGGER.info("Le livre est envoyé pour traitement.");
        return bookConsumerMessage;
    }

    @Override
    public void sendToKafka(BookConsumerMessage bookConsumerMessage) {
        kafkaTemplate.send("topic-bibliotech-books", Long.valueOf(bookConsumerMessage.getIsbnId()));
    }
}
