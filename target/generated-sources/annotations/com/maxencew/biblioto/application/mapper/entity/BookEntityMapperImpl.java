package com.maxencew.biblioto.application.mapper.entity;

import com.maxencew.biblioto.application.exception.MappingEntityException;
import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.model.Editor;
import com.maxencew.biblioto.domain.model.Library;
import com.maxencew.biblioto.domain.model.Owner;
import com.maxencew.biblioto.domain.model.Theme;
import com.maxencew.biblioto.infrastructure.entity.BookEntity;
import com.maxencew.biblioto.infrastructure.entity.EditorEntity;
import com.maxencew.biblioto.infrastructure.entity.LibraryEntity;
import com.maxencew.biblioto.infrastructure.entity.OwnerEntity;
import com.maxencew.biblioto.infrastructure.entity.ThemeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import com.maxencew.biblioto.infrastructure.mapper.entity.BookEntityMapper;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-12T16:56:09+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class BookEntityMapperImpl implements BookEntityMapper {

    @Override
    public BookEntity toEntity(Book book) throws MappingEntityException {
        if ( book == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setId( book.getId() );
        bookEntity.setIsbnId( book.getIsbnId() );
        bookEntity.setOldIsbnId( book.getOldIsbnId() );
        bookEntity.setTitle( book.getTitle() );
        bookEntity.setAuthorName( book.getAuthorName() );
        bookEntity.setTitleLong( book.getTitleLong() );
        bookEntity.setSubtitle( book.getSubtitle() );
        bookEntity.setSynopsis( book.getSynopsis() );
        bookEntity.setSummary( book.getSummary() );
        bookEntity.setNumberOfPage( book.getNumberOfPage() );
        bookEntity.setOpenLibraryId( book.getOpenLibraryId() );
        bookEntity.setCoverPageUrl( book.getCoverPageUrl() );
        bookEntity.setTraductionLanguage( book.getTraductionLanguage() );
        bookEntity.setInitialLanguage( book.getInitialLanguage() );
        bookEntity.setFirstPublishYear( book.getFirstPublishYear() );
        bookEntity.setFirstSentence( book.getFirstSentence() );
        bookEntity.setEditor( editorToEditorEntity( book.getEditor() ) );
        bookEntity.setLibrary( libraryToLibraryEntity( book.getLibrary() ) );
        bookEntity.setOwner( ownerToOwnerEntity( book.getOwner() ) );
        bookEntity.setThemes( themeListToThemeEntityList( book.getThemes() ) );
        bookEntity.setOverallReception( book.getOverallReception() );
        bookEntity.setPraises( book.getPraises() );
        bookEntity.setCriticisms( book.getCriticisms() );
        bookEntity.setIsWishList( book.getIsWishList() );
        bookEntity.setIsAnOpenLibaryApiRegister( book.getIsAnOpenLibaryApiRegister() );
        bookEntity.setIsAnOpenLibaryApiBookValidate( book.getIsAnOpenLibaryApiBookValidate() );

        return bookEntity;
    }

    @Override
    public Book toDomain(BookEntity bookEntity) throws MappingEntityException {
        if ( bookEntity == null ) {
            return null;
        }

        Book.BookBuilder book = Book.builder();

        book.id( bookEntity.getId() );
        book.isbnId( bookEntity.getIsbnId() );
        book.oldIsbnId( bookEntity.getOldIsbnId() );
        book.title( bookEntity.getTitle() );
        book.authorName( bookEntity.getAuthorName() );
        book.titleLong( bookEntity.getTitleLong() );
        book.subtitle( bookEntity.getSubtitle() );
        book.synopsis( bookEntity.getSynopsis() );
        book.summary( bookEntity.getSummary() );
        book.numberOfPage( bookEntity.getNumberOfPage() );
        book.openLibraryId( bookEntity.getOpenLibraryId() );
        book.coverPageUrl( bookEntity.getCoverPageUrl() );
        book.traductionLanguage( bookEntity.getTraductionLanguage() );
        book.initialLanguage( bookEntity.getInitialLanguage() );
        book.firstPublishYear( bookEntity.getFirstPublishYear() );
        book.firstSentence( bookEntity.getFirstSentence() );
        book.editor( editorEntityToEditor( bookEntity.getEditor() ) );
        book.library( libraryEntityToLibrary( bookEntity.getLibrary() ) );
        book.owner( ownerEntityToOwner( bookEntity.getOwner() ) );
        book.themes( themeEntityListToThemeList( bookEntity.getThemes() ) );
        book.overallReception( bookEntity.getOverallReception() );
        book.praises( bookEntity.getPraises() );
        book.criticisms( bookEntity.getCriticisms() );
        book.isWishList( bookEntity.getIsWishList() );
        book.isAnOpenLibaryApiRegister( bookEntity.getIsAnOpenLibaryApiRegister() );
        book.isAnOpenLibaryApiBookValidate( bookEntity.getIsAnOpenLibaryApiBookValidate() );

        return book.build();
    }

    @Override
    public List<Book> toDomainList(List<BookEntity> entities) throws MappingEntityException {
        if ( entities == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( entities.size() );
        for ( BookEntity bookEntity : entities ) {
            list.add( toDomain( bookEntity ) );
        }

        return list;
    }

    @Override
    public List<BookEntity> toEntityList(List<Book> books) throws MappingEntityException {
        if ( books == null ) {
            return null;
        }

        List<BookEntity> list = new ArrayList<BookEntity>( books.size() );
        for ( Book book : books ) {
            list.add( toEntity( book ) );
        }

        return list;
    }

    protected EditorEntity editorToEditorEntity(Editor editor) {
        if ( editor == null ) {
            return null;
        }

        EditorEntity editorEntity = new EditorEntity();

        editorEntity.setId( editor.getId() );
        editorEntity.setName( editor.getName() );
        editorEntity.setCategory( editor.getCategory() );
        editorEntity.setEdition( editor.getEdition() );

        return editorEntity;
    }

    protected LibraryEntity libraryToLibraryEntity(Library library) {
        if ( library == null ) {
            return null;
        }

        LibraryEntity libraryEntity = new LibraryEntity();

        libraryEntity.setId( library.getId() );
        libraryEntity.setName( library.getName() );
        libraryEntity.setLocation( library.getLocation() );
        libraryEntity.setCapacity( library.getCapacity() );

        return libraryEntity;
    }

    protected OwnerEntity ownerToOwnerEntity(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerEntity ownerEntity = new OwnerEntity();

        ownerEntity.setId( owner.getId() );
        ownerEntity.setFirstName( owner.getFirstName() );
        ownerEntity.setLastName( owner.getLastName() );
        ownerEntity.setNote( owner.getNote() );

        return ownerEntity;
    }

    protected ThemeEntity themeToThemeEntity(Theme theme) {
        if ( theme == null ) {
            return null;
        }

        ThemeEntity themeEntity = new ThemeEntity();

        themeEntity.setId( theme.getId() );
        themeEntity.setName( theme.getName() );
        List<String> list = theme.getKeywords();
        if ( list != null ) {
            themeEntity.setKeywords( new ArrayList<String>( list ) );
        }

        return themeEntity;
    }

    protected List<ThemeEntity> themeListToThemeEntityList(List<Theme> list) {
        if ( list == null ) {
            return null;
        }

        List<ThemeEntity> list1 = new ArrayList<ThemeEntity>( list.size() );
        for ( Theme theme : list ) {
            list1.add( themeToThemeEntity( theme ) );
        }

        return list1;
    }

    protected Editor editorEntityToEditor(EditorEntity editorEntity) {
        if ( editorEntity == null ) {
            return null;
        }

        Editor.EditorBuilder editor = Editor.builder();

        editor.id( editorEntity.getId() );
        editor.name( editorEntity.getName() );
        editor.category( editorEntity.getCategory() );
        editor.edition( editorEntity.getEdition() );

        return editor.build();
    }

    protected Library libraryEntityToLibrary(LibraryEntity libraryEntity) {
        if ( libraryEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String location = null;
        Integer capacity = null;

        id = libraryEntity.getId();
        name = libraryEntity.getName();
        location = libraryEntity.getLocation();
        capacity = libraryEntity.getCapacity();

        Library library = new Library( id, name, location, capacity );

        return library;
    }

    protected Owner ownerEntityToOwner(OwnerEntity ownerEntity) {
        if ( ownerEntity == null ) {
            return null;
        }

        Long id = null;
        String firstName = null;
        String lastName = null;
        String note = null;

        id = ownerEntity.getId();
        firstName = ownerEntity.getFirstName();
        lastName = ownerEntity.getLastName();
        note = ownerEntity.getNote();

        Owner owner = new Owner( id, firstName, lastName, note );

        return owner;
    }

    protected Theme themeEntityToTheme(ThemeEntity themeEntity) {
        if ( themeEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        List<String> keywords = null;

        id = themeEntity.getId();
        name = themeEntity.getName();
        List<String> list = themeEntity.getKeywords();
        if ( list != null ) {
            keywords = new ArrayList<String>( list );
        }

        Theme theme = new Theme( id, name, keywords );

        return theme;
    }

    protected List<Theme> themeEntityListToThemeList(List<ThemeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Theme> list1 = new ArrayList<Theme>( list.size() );
        for ( ThemeEntity themeEntity : list ) {
            list1.add( themeEntityToTheme( themeEntity ) );
        }

        return list1;
    }
}
