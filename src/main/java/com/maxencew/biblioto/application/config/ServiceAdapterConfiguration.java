package com.maxencew.biblioto.application.config;

import com.maxencew.biblioto.application.service.adapter.BookServiceAdapter;
import com.maxencew.biblioto.domain.ports.spi.BookPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceAdapterConfiguration {

//    @Bean
//    public BookServiceAdapter getBookService(BookPersistencePort bookPersistencePort, IsbnApiServiceAdapter isbnApiService) {
//        return new BookServiceAdapter(bookPersistencePort, isbnApiService);
//    }
}
