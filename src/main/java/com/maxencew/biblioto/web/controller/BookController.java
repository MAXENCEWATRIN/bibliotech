package com.maxencew.biblioto.web.controller;

import com.maxencew.biblioto.application.mapper.dto.BookDtoMapper;
import com.maxencew.biblioto.application.request.BookRequest;
import com.maxencew.biblioto.application.response.BookResponse;
import com.maxencew.biblioto.application.response.BibliotoHttpResponse;
import com.maxencew.biblioto.application.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookServiceAdapter;

    @Autowired
    private BookDtoMapper bookDtoMapper;

    @PostMapping
    public BibliotoHttpResponse<BookResponse> addBook(@RequestBody BookRequest book) {
        return BibliotoHttpResponse.success(bookDtoMapper.toDto(bookServiceAdapter.addBook(bookDtoMapper.toDomain(book))));
    }

    @PutMapping("/{id}")
    public BibliotoHttpResponse<BookResponse> updateBook(@PathVariable Long id, @RequestBody BookRequest book) {
        book.setId(id);
        return BibliotoHttpResponse.success(bookDtoMapper.toDto(bookServiceAdapter.addBook(bookDtoMapper.toDomain(book))));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id, @RequestBody BookRequest book) {
        book.setId(id);
        bookServiceAdapter.removeBook(bookDtoMapper.toDomain(book));
    }

    @GetMapping
    public BibliotoHttpResponse<List<BookResponse>> getAllBooks() {
        return BibliotoHttpResponse.success(bookDtoMapper.toDtoList(bookServiceAdapter.getBooks()));
    }

    @GetMapping("/{id}")
    public BibliotoHttpResponse<BookResponse> getBookById(@PathVariable Long id) {
        return BibliotoHttpResponse.success(bookDtoMapper.toDto(bookServiceAdapter.getBookById(id)));
    }

    @GetMapping("isbn/{id}")
    public BibliotoHttpResponse<BookResponse> getBookByIsbn(@PathVariable Long id) {
        return BibliotoHttpResponse.success(bookDtoMapper.toDto(bookServiceAdapter.getByIsbnId(id)));
    }

}
