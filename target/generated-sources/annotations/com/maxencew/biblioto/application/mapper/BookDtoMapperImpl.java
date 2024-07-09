package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.application.request.BookRequest;
import com.maxencew.biblioto.application.response.BookResponse;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.model.Editor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T00:17:20+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class BookDtoMapperImpl implements BookDtoMapper {

    @Override
    public Book toDomain(BookRequest request) {
        if ( request == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.isbnId( request.getIsbnId() );
        book.oldIsbnId( request.getOldIsbnId() );
        book.title( request.getTitle() );
        book.authorName( request.getAuthorName() );
        book.titleLong( request.getTitleLong() );
        book.subtitle( request.getSubtitle() );
        book.synopsis( request.getSynopsis() );
        book.summary( request.getSummary() );
        book.numberOfPage( request.getNumberOfPage() );
        book.openLibraryId( request.getOpenLibraryId() );
        book.coverPageUrl( request.getCoverPageUrl() );
        book.traductionLanguage( request.getTraductionLanguage() );
        book.initialLanguage( request.getInitialLanguage() );
        book.firstPublishYear( request.getFirstPublishYear() );
        book.firstSentence( request.getFirstSentence() );
        book.editor( request.getEditor() );
        book.isWishList( request.getIsWishList() );
        book.isAnOpenLibaryApiRegister( request.getIsAnOpenLibaryApiRegister() );
        book.isAnOpenLibaryApiBookValidate( request.getIsAnOpenLibaryApiBookValidate() );

        return book.build();
    }

    @Override
    public BookResponse toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        Long id = null;
        BigDecimal isbnId = null;
        BigDecimal oldIsbnId = null;
        String title = null;
        String authorName = null;
        String titleLong = null;
        String subtitle = null;
        String synopsis = null;
        String summary = null;
        Integer numberOfPage = null;
        String openLibraryId = null;
        String coverPageUrl = null;
        String traductionLanguage = null;
        String initialLanguage = null;
        Integer firstPublishYear = null;
        String firstSentence = null;
        Editor editor = null;
        Boolean isWishList = null;
        Boolean isAnOpenLibaryApiRegister = null;
        Boolean isAnOpenLibaryApiBookValidate = null;

        id = book.getId();
        isbnId = book.getIsbnId();
        oldIsbnId = book.getOldIsbnId();
        title = book.getTitle();
        authorName = book.getAuthorName();
        titleLong = book.getTitleLong();
        subtitle = book.getSubtitle();
        synopsis = book.getSynopsis();
        summary = book.getSummary();
        numberOfPage = book.getNumberOfPage();
        openLibraryId = book.getOpenLibraryId();
        coverPageUrl = book.getCoverPageUrl();
        traductionLanguage = book.getTraductionLanguage();
        initialLanguage = book.getInitialLanguage();
        firstPublishYear = book.getFirstPublishYear();
        firstSentence = book.getFirstSentence();
        editor = book.getEditor();
        isWishList = book.getIsWishList();
        isAnOpenLibaryApiRegister = book.getIsAnOpenLibaryApiRegister();
        isAnOpenLibaryApiBookValidate = book.getIsAnOpenLibaryApiBookValidate();

        BookResponse bookResponse = new BookResponse( id, isbnId, oldIsbnId, title, authorName, titleLong, subtitle, synopsis, summary, numberOfPage, openLibraryId, coverPageUrl, traductionLanguage, initialLanguage, firstPublishYear, firstSentence, editor, isWishList, isAnOpenLibaryApiRegister, isAnOpenLibaryApiBookValidate );

        return bookResponse;
    }

    @Override
    public List<Book> toDomainList(List<BookRequest> booksRequested) {
        if ( booksRequested == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( booksRequested.size() );
        for ( BookRequest bookRequest : booksRequested ) {
            list.add( toDomain( bookRequest ) );
        }

        return list;
    }

    @Override
    public List<BookResponse> toDtoList(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookResponse> list = new ArrayList<BookResponse>( books.size() );
        for ( Book book : books ) {
            list.add( toDto( book ) );
        }

        return list;
    }
}
