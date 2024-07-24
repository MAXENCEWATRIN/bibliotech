package com.maxencew.bibliotech.infrastructure.configuration;

import com.maxencew.bibliotech.application.service.api.*;
import com.maxencew.bibliotech.domain.adapter.*;
import com.maxencew.bibliotech.domain.ports.spi.*;
import com.mongodb.client.gridfs.GridFSBucket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    EditorService editorService(EditorPersistencePort editorRepository) {
        return new EditorServiceAdapter(editorRepository);
    }

    @Bean
    LibraryService libraryService(LibraryPersistencePort libraryPersistencePort) {
        return new LibraryServiceAdapter(libraryPersistencePort);
    }

    @Bean
    OwnerService ownerService(OwnerPersistencePort ownerPersistencePort) {
        return new OwnerServiceAdapter(ownerPersistencePort);
    }

    @Bean
    ThemeService themeService(ThemePersistencePort themePersistencePort) {
        return new ThemeServiceAdapter(themePersistencePort);
    }

    @Bean
    OpenAIService openAIService(Environment environment, AppConfig appConfig) {
        return new OpenAIAdapter(environment, appConfig);
    }

    @Bean
    OpenAIService isbnService(Environment environment, AppConfig appConfig) {
        return new OpenAIAdapter(environment, appConfig);
    }

    @Bean
    ImageService imageDownloaderService(GridFSBucket gridFSBucket, AppConfig appConfig) {
        return new ImageDownloaderService(gridFSBucket, appConfig);
    }


    @Bean
    BookService bookService(BookPersistencePort bookPersistencePort, EditorPersistencePort editorPersistencePort,
                            LibraryPersistencePort libraryPersistencePort, OwnerPersistencePort ownerPersistencePort,
                            ThemePersistencePort themePersistencePort, ImageService imageDownloaderService, OpenAIService openAIService,
                            OpenLibraryApiPort openLibraryApiPort, Environment environment) {
        return new BookServiceAdapter(bookPersistencePort, editorPersistencePort, libraryPersistencePort, ownerPersistencePort, themePersistencePort,
                imageDownloaderService, openAIService, openLibraryApiPort, environment);
    }




}
