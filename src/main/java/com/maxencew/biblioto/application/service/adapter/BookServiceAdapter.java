package com.maxencew.biblioto.application.service.adapter;

import com.maxencew.biblioto.application.response.ChatGptSummariseBookPattern;
import com.maxencew.biblioto.application.service.IsbnService;
import com.maxencew.biblioto.application.service.api.BookService;
import com.maxencew.biblioto.application.service.api.OpenAIService;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.ports.spi.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class BookServiceAdapter implements BookService {

    @Autowired
    private final BookPersistencePort bookPersistencePort;
    @Autowired
    private final EditorPersistencePort editorPersistencePort;
    @Autowired
    private final LibraryPersistencePort libraryPersistencePort;
    @Autowired
    private final OwnerPersistencePort ownerPersistencePort;
    @Autowired
    private final ThemePersistencePort themePersistencePort;
    @Autowired
    private final IsbnService isbnService;
    @Autowired
    private final OpenAIService openAIService;

    @Transactional
    public Book addBook(Book book) {
        if(Objects.nonNull(book.getEditor()) && Objects.isNull(book.getEditor().getId())) {
            book.setEditor(editorPersistencePort.addEditor(book.getEditor()));
        }
        if(Objects.nonNull(book.getLibrary()) && Objects.isNull(book.getLibrary().getId())) {
            book.setLibrary(libraryPersistencePort.addLibrary(book.getLibrary()));
        }
        if(Objects.nonNull(book.getOwner()) && Objects.isNull(book.getOwner().getId())) {
            book.setOwner(ownerPersistencePort.addOwner(book.getOwner()));
        }
        if(Objects.nonNull(book.getThemes()) && !book.getThemes().isEmpty()) {
            book.setThemes(
                    book.getThemes()
                            .stream()
                            .filter(theme -> Objects.isNull(theme.getId()))
                            .map(themePersistencePort::addTheme)
                            .collect(Collectors.toList())
            );
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
        final var bookRetrieveByIsbnId = this.bookPersistencePort.getBookByIsbnId(isbnId);

        if (Objects.isNull(bookRetrieveByIsbnId)) {
            LOGGER.info("The Isbn id {} didn't exist yet, trying to retrieve information on external API.", isbnId);
            final Book book = isbnService.findBookByIsbnIdOnExternalResources(isbnId);
            LOGGER.info("ISBN ID returned information from the book on OpenLibraryAPi");
            LOGGER.info("Contact with ChatGPT API to add some information to the book.");
            final ChatGptSummariseBookPattern complementaryInformations =
                    openAIService.getBookInformation(book.getTitle(), book.getAuthorName());
            book.setSynopsis(complementaryInformations.getSynopsis());
            book.setSummary(complementaryInformations.getSummary());
            book.setOverallReception(complementaryInformations.getPublicOpinions().getOverallReception());
            book.setCriticisms(complementaryInformations.getPublicOpinions().getCriticisms());
            book.setPraises(complementaryInformations.getPublicOpinions().getPraises());
            LOGGER.info("All complementary information had been successfully retrieved.");
            return book;
        }

        return bookRetrieveByIsbnId;
    }


}
