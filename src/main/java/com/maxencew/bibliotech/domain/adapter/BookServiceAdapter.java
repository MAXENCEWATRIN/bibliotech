package com.maxencew.bibliotech.domain.adapter;

import com.maxencew.bibliotech.application.response.ChatGptSummariseBookPattern;
import com.maxencew.bibliotech.application.service.api.BookService;
import com.maxencew.bibliotech.application.service.api.ImageService;
import com.maxencew.bibliotech.application.service.api.OpenAIService;
import com.maxencew.bibliotech.domain.model.Book;
import com.maxencew.bibliotech.domain.ports.spi.*;
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
                            .map(theme -> Objects.nonNull(theme.getId()) ? theme : themePersistencePort.addTheme(theme))
                            .collect(Collectors.toList())
            );
        }

        if(Objects.nonNull(book.getId()) && (book.getCoverPageUrl() != null && !book.getCoverPageUrl().isEmpty())) {
            Book retrieveBook = this.bookPersistencePort.getBookById(book.getId());
            try {
                if(Objects.nonNull(retrieveBook.getCoverImageId())) {
                    imageDownloaderService.deleteImageById(retrieveBook.getCoverImageId());
                }
            } catch (Exception e) {
                LOGGER.error("Erreur lors de la suppression de l'image dans la base.", e);
            }
            ObjectId imageId = imageDownloaderService.downloadAndStoreImage(book.getCoverPageUrl());
            book.setCoverImageId(imageId);
            book.setCoverPageUrl(null);
            LOGGER.info("Livre existant (id : {}), avec remplacement de la couverture (id : {}).", book.getId(), book.getCoverImageId());
            return this.bookPersistencePort.addBook(book);
        } else if (Objects.nonNull(book.getId()) && (Objects.isNull(book.getCoverPageUrl())  || book.getCoverPageUrl().isEmpty())) {
            Book retrieveBook = this.bookPersistencePort.getBookById(book.getId());
            book.setCoverImageId(retrieveBook.getCoverImageId());
            book.setCoverPageUrl(null);
            LOGGER.info("Livre existant (id : {}), sans remplacement de la couverture (id : {}).", book.getId(), book.getCoverImageId());
            return this.bookPersistencePort.addBook(book);
        } else {
            ObjectId imageId = imageDownloaderService.downloadAndStoreImage(book.getCoverPageUrl());
            book.setCoverImageId(imageId);
            book.setCoverPageUrl(null);
            LOGGER.info("Création d'un livre (nom : {}), création de la couverture.", book.getTitle());
            return this.bookPersistencePort.addBook(book);
        }

    }

    public void removeBook(Book book) {
        this.bookPersistencePort.removeBook(book);
    }

    public List<Book> getBooks() {
        return this.bookPersistencePort.getBooks();
    }

    public Book getBookById(Long id) {
        Book bookById = this.bookPersistencePort.getBookById(id);
        return bookById;
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