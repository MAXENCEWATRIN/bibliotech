package com.maxencew.biblioto.application.mapper.dto;

import com.maxencew.biblioto.application.exception.MappingDtoException;
import com.maxencew.biblioto.application.request.BookRequest;
import com.maxencew.biblioto.application.request.EditorRequest;
import com.maxencew.biblioto.application.request.LibraryRequest;
import com.maxencew.biblioto.application.request.OwnerRequest;
import com.maxencew.biblioto.application.request.ThemeRequest;
import com.maxencew.biblioto.application.response.BookResponse;
import com.maxencew.biblioto.application.response.EditorResponse;
import com.maxencew.biblioto.application.response.LibraryResponse;
import com.maxencew.biblioto.application.response.OwnerResponse;
import com.maxencew.biblioto.application.response.ThemeResponse;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.model.Editor;
import com.maxencew.biblioto.domain.model.Library;
import com.maxencew.biblioto.domain.model.Owner;
import com.maxencew.biblioto.domain.model.Theme;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-11T21:24:48+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class BookDtoMapperImpl implements BookDtoMapper {

    @Override
    public Book toDomain(BookRequest request) throws MappingDtoException {
        if ( request == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.id( request.getId() );
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
        book.editor( editorRequestToEditor( request.getEditor() ) );
        book.library( libraryRequestToLibrary( request.getLibrary() ) );
        book.owner( ownerRequestToOwner( request.getOwner() ) );
        book.themes( themeRequestListToThemeList( request.getThemes() ) );
        book.overallReception( request.getOverallReception() );
        book.praises( request.getPraises() );
        book.criticisms( request.getCriticisms() );
        book.isWishList( request.getIsWishList() );
        book.isAnOpenLibaryApiRegister( request.getIsAnOpenLibaryApiRegister() );
        book.isAnOpenLibaryApiBookValidate( request.getIsAnOpenLibaryApiBookValidate() );

        return book.build();
    }

    @Override
    public BookResponse toDto(Book book) throws MappingDtoException {
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
        EditorResponse editor = null;
        LibraryResponse library = null;
        List<ThemeResponse> themes = null;
        OwnerResponse owner = null;
        Boolean isWishList = null;
        String overallReception = null;
        String praises = null;
        String criticisms = null;
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
        editor = editorToEditorResponse( book.getEditor() );
        library = libraryToLibraryResponse( book.getLibrary() );
        themes = themeListToThemeResponseList( book.getThemes() );
        owner = ownerToOwnerResponse( book.getOwner() );
        isWishList = book.getIsWishList();
        overallReception = book.getOverallReception();
        praises = book.getPraises();
        criticisms = book.getCriticisms();
        isAnOpenLibaryApiRegister = book.getIsAnOpenLibaryApiRegister();
        isAnOpenLibaryApiBookValidate = book.getIsAnOpenLibaryApiBookValidate();

        BookResponse bookResponse = new BookResponse( id, isbnId, oldIsbnId, title, authorName, titleLong, subtitle, synopsis, summary, numberOfPage, openLibraryId, coverPageUrl, traductionLanguage, initialLanguage, firstPublishYear, firstSentence, editor, library, themes, owner, isWishList, overallReception, praises, criticisms, isAnOpenLibaryApiRegister, isAnOpenLibaryApiBookValidate );

        return bookResponse;
    }

    @Override
    public List<Book> toDomainList(List<BookRequest> booksRequested) throws MappingDtoException {
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
    public List<BookResponse> toDtoList(List<Book> books) throws MappingDtoException {
        if ( books == null ) {
            return null;
        }

        List<BookResponse> list = new ArrayList<BookResponse>( books.size() );
        for ( Book book : books ) {
            list.add( toDto( book ) );
        }

        return list;
    }

    protected Editor editorRequestToEditor(EditorRequest editorRequest) {
        if ( editorRequest == null ) {
            return null;
        }

        Editor.EditorBuilder editor = Editor.builder();

        editor.id( editorRequest.getId() );
        editor.name( editorRequest.getName() );
        editor.category( editorRequest.getCategory() );
        editor.edition( editorRequest.getEdition() );

        return editor.build();
    }

    protected Library libraryRequestToLibrary(LibraryRequest libraryRequest) {
        if ( libraryRequest == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String location = null;
        Integer capacity = null;

        id = libraryRequest.getId();
        name = libraryRequest.getName();
        location = libraryRequest.getLocation();
        capacity = libraryRequest.getCapacity();

        Library library = new Library( id, name, location, capacity );

        return library;
    }

    protected Owner ownerRequestToOwner(OwnerRequest ownerRequest) {
        if ( ownerRequest == null ) {
            return null;
        }

        Long id = null;
        String firstName = null;
        String lastName = null;
        String note = null;

        id = ownerRequest.getId();
        firstName = ownerRequest.getFirstName();
        lastName = ownerRequest.getLastName();
        note = ownerRequest.getNote();

        Owner owner = new Owner( id, firstName, lastName, note );

        return owner;
    }

    protected Theme themeRequestToTheme(ThemeRequest themeRequest) {
        if ( themeRequest == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        List<String> keywords = null;

        id = themeRequest.getId();
        name = themeRequest.getName();
        List<String> list = themeRequest.getKeywords();
        if ( list != null ) {
            keywords = new ArrayList<String>( list );
        }

        Theme theme = new Theme( id, name, keywords );

        return theme;
    }

    protected List<Theme> themeRequestListToThemeList(List<ThemeRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Theme> list1 = new ArrayList<Theme>( list.size() );
        for ( ThemeRequest themeRequest : list ) {
            list1.add( themeRequestToTheme( themeRequest ) );
        }

        return list1;
    }

    protected EditorResponse editorToEditorResponse(Editor editor) {
        if ( editor == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String category = null;
        String edition = null;

        id = editor.getId();
        name = editor.getName();
        category = editor.getCategory();
        edition = editor.getEdition();

        List<BookResponse> books = null;

        EditorResponse editorResponse = new EditorResponse( id, name, category, edition, books );

        return editorResponse;
    }

    protected LibraryResponse libraryToLibraryResponse(Library library) {
        if ( library == null ) {
            return null;
        }

        LibraryResponse libraryResponse = new LibraryResponse();

        libraryResponse.setId( library.getId() );
        libraryResponse.setName( library.getName() );
        libraryResponse.setLocation( library.getLocation() );
        libraryResponse.setCapacity( library.getCapacity() );

        return libraryResponse;
    }

    protected ThemeResponse themeToThemeResponse(Theme theme) {
        if ( theme == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        List<String> keywords = null;

        id = theme.getId();
        name = theme.getName();
        List<String> list = theme.getKeywords();
        if ( list != null ) {
            keywords = new ArrayList<String>( list );
        }

        List<BookResponse> books = null;

        ThemeResponse themeResponse = new ThemeResponse( id, name, keywords, books );

        return themeResponse;
    }

    protected List<ThemeResponse> themeListToThemeResponseList(List<Theme> list) {
        if ( list == null ) {
            return null;
        }

        List<ThemeResponse> list1 = new ArrayList<ThemeResponse>( list.size() );
        for ( Theme theme : list ) {
            list1.add( themeToThemeResponse( theme ) );
        }

        return list1;
    }

    protected OwnerResponse ownerToOwnerResponse(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerResponse ownerResponse = new OwnerResponse();

        ownerResponse.setId( owner.getId() );
        ownerResponse.setFirstName( owner.getFirstName() );
        ownerResponse.setLastName( owner.getLastName() );
        ownerResponse.setNote( owner.getNote() );

        return ownerResponse;
    }
}
