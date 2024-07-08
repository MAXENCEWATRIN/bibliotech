package com.maxencew.biblioto.infrastructure.configuration;

import com.maxencew.biblioto.application.mapper.BookEntityMapper;
import com.maxencew.biblioto.domain.ports.spi.BookPersistencePort;
import com.maxencew.biblioto.infrastructure.adapter.BookPersistenceAdapter;
import com.maxencew.biblioto.infrastructure.repository.BookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaAdapterConfiguration {

//    @Bean
//    public BookPersistencePort getBookPersistencePort(BookRepository bookRepository, BookEntityMapper bookEntityMapper) {
//        return new BookPersistenceAdapter(bookRepository, bookEntityMapper);
//    }
}
