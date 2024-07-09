package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.domain.model.Book;
import com.maxencew.biblioto.domain.model.Editor;
import com.maxencew.biblioto.infrastructure.entity.BookEntity;
import com.maxencew.biblioto.infrastructure.entity.EditorEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T00:17:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class BookEntityMapperImpl implements BookEntityMapper {

    @Override
    public BookEntity toEntity(Book book) {
        if ( book == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

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
        bookEntity.setIsAnOpenLibaryApiRegister( book.getIsAnOpenLibaryApiRegister() );
        bookEntity.setIsAnOpenLibaryApiBookValidate( book.getIsAnOpenLibaryApiBookValidate() );

        return bookEntity;
    }

    @Override
    public Book toDomain(BookEntity bookEntity) {
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
        book.isAnOpenLibaryApiRegister( bookEntity.getIsAnOpenLibaryApiRegister() );
        book.isAnOpenLibaryApiBookValidate( bookEntity.getIsAnOpenLibaryApiBookValidate() );

        return book.build();
    }

    @Override
    public List<Book> toDomainList(List<BookEntity> entities) {
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
    public List<BookEntity> toEntityList(List<Book> books) {
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

        Long id = null;
        String name = null;
        String category = null;

        id = editor.getId();
        name = editor.getName();
        category = editor.getCategory();

        List<BookEntity> books = null;

        EditorEntity editorEntity = new EditorEntity( id, name, category, books );

        return editorEntity;
    }

    protected Editor editorEntityToEditor(EditorEntity editorEntity) {
        if ( editorEntity == null ) {
            return null;
        }

        Editor.EditorBuilder editor = Editor.builder();

        editor.id( editorEntity.getId() );
        editor.name( editorEntity.getName() );
        editor.category( editorEntity.getCategory() );

        return editor.build();
    }
}
