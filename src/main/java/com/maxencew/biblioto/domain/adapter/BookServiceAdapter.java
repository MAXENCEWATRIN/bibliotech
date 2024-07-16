package com.maxencew.biblioto.domain.adapter;

import com.maxencew.biblioto.application.response.ChatGptSummariseBookPattern;
import com.maxencew.biblioto.application.service.api.BookService;
import com.maxencew.biblioto.application.service.api.ImageService;
import com.maxencew.biblioto.application.service.api.OpenAIService;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.ports.spi.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@AllArgsConstructor
public class BookServiceAdapter implements BookService {


    private final BookPersistencePort bookPersistencePort;

    private final EditorPersistencePort editorPersistencePort;

    private final LibraryPersistencePort libraryPersistencePort;

    private final OwnerPersistencePort ownerPersistencePort;

    private final ThemePersistencePort themePersistencePort;

    private final ImageService imageDownloaderService;

    private final OpenAIService openAIService;

    private final OpenLibraryApiPort openLibraryApiPort;
    private final Environment environment;

    @Transactional
    public Book addBook(Book book) {
        if (Objects.nonNull(book.getEditor()) && Objects.isNull(book.getEditor().getId())) {
            book.setEditor(editorPersistencePort.addEditor(book.getEditor()));
        }
        if (Objects.nonNull(book.getLibrary()) && Objects.isNull(book.getLibrary().getId())) {
            book.setLibrary(libraryPersistencePort.addLibrary(book.getLibrary()));
        }
        if (Objects.nonNull(book.getOwner()) && Objects.isNull(book.getOwner().getId())) {
            book.setOwner(ownerPersistencePort.addOwner(book.getOwner()));
        }
        if (Objects.nonNull(book.getThemes()) && !book.getThemes().isEmpty()) {
            book.setThemes(
                    book.getThemes()
                            .stream()
                            .filter(theme -> Objects.isNull(theme.getId()))
                            .map(themePersistencePort::addTheme)
                            .collect(Collectors.toList())
            );
        }
        if (book.getCoverPageUrl() != null && !book.getCoverPageUrl().isEmpty()) {
            ObjectId imageId = imageDownloaderService.downloadAndStoreImage(book.getCoverPageUrl());
            book.setCoverImageId(imageId);
        }

        return this.bookPersistencePort.addBook(book);
    }

    public void removeBook(Book book) {
        this.bookPersistencePort.removeBook(book);
    }

    public List<Book> getBooks() {
        return this.bookPersistencePort.getBooks();
    }

    public Book getBookById(Long id) {
        return this.bookPersistencePort.getBookById(id);
    }

    public Book getByIsbnId(Long isbnId) {
        Book bookRetrieveByIsbnId = this.bookPersistencePort.getBookByIsbnId(isbnId);
        if (Objects.isNull(bookRetrieveByIsbnId)) {
            LOGGER.info("The Isbn id {} didn't exist yet, trying to retrieve information on external API.", isbnId);
            bookRetrieveByIsbnId = this.bookPersistencePort.getBookByIsbnId(isbnId);
            if (Objects.isNull(bookRetrieveByIsbnId)) {
                LOGGER.info("Information from ISBN api will be retrieve for the id {}", isbnId);
                final Optional<Book> book = openLibraryApiPort.retrieveBookInformation(isbnId);
                if (book.isEmpty()) {
                    throw new IllegalArgumentException("Aucune info sur ce livre dans l'API openLibrary.");
                }
                Book buildBook = book.get();
                LOGGER.info("{}, {}, {}, {}", buildBook.getAuthorName(), buildBook.getTitle(), buildBook.getIsbnId(), buildBook.getNumberOfPage());

                LOGGER.info("ISBN ID returned information from the book on OpenLibraryAPi");
                LOGGER.info("Contact with ChatGPT API to add some information to the book.");
                //TODO : Désactivé par économie .
                if (Boolean.getBoolean(environment.getProperty("external.api.openAI.active"))) {
                    final ChatGptSummariseBookPattern complementaryInformations =
                            openAIService.getBookInformation(buildBook.getTitle(), buildBook.getAuthorName());
                    buildBook.setSynopsis(complementaryInformations.getSynopsis());
                    buildBook.setSummary(complementaryInformations.getSummary());
                    buildBook.setOverallReception(complementaryInformations.getPublicOpinions().getOverallReception());
                    buildBook.setCriticisms(complementaryInformations.getPublicOpinions().getCriticisms());
                    buildBook.setPraises(complementaryInformations.getPublicOpinions().getPraises());
                    LOGGER.info("All complementary information had been successfully retrieved.");
                }
                return buildBook;
            }


        }

        return bookRetrieveByIsbnId;
    }
}