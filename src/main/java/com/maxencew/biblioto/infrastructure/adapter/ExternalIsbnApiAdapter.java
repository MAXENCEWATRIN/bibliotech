package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.ports.spi.ExternalIsbnApiPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class ExternalIsbnApiAdapter implements ExternalIsbnApiPort {
    @Override
    public Optional<Book> fetchBookDetails(Long isbnId) {
        return Optional.empty();
    }


//    private final ExternalApiConfiguration externalApiConfiguration;
//    private final RestTemplate restTemplate;
//
//    @Deprecated
//    @Override
//    public Optional<Book> fetchBookDetails(Long isbnId) {
//        String url = String.format("%s/books/%s", externalApiConfiguration.getApiIsbnUrl(), isbnId);
//        ResponseEntity<Book> response = restTemplate.getForEntity(url, Book.class);
//        LOGGER.info("{} - Api Call to ISBN API result.", response.getStatusCode());
//        return Optional.ofNullable(response.getBody());
//    }
}
