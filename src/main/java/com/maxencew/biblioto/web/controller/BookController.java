package com.maxencew.biblioto.infrastructure.controller;

import com.maxencew.biblioto.application.mapper.BookDtoMapper;
import com.maxencew.biblioto.application.request.BookRequest;
import com.maxencew.biblioto.application.response.BookResponse;
import com.maxencew.biblioto.application.service.adapter.BookServiceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServiceAdapter bookService;

    @Autowired
    private BookDtoMapper bookDtoMapper;

    @PostMapping
    public BookResponse addBook(@RequestBody BookRequest book) {
        return bookDtoMapper.toDto(bookService.add(bookDtoMapper.toDomain(book)));
    }

    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable Long id, @RequestBody BookRequest book) {
        book.setId(id);
        return bookDtoMapper.toDto(bookService.add(bookDtoMapper.toDomain(book)));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id, @RequestBody BookRequest book) {
        book.setId(id);
        bookService.delete(bookDtoMapper.toDomain(book));
    }

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookDtoMapper.toDtoList(bookService.getAll());
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return bookDtoMapper.toDto(bookService.getById(id));
    }

    @GetMapping("isbn/{id}")
    public BookResponse getBookByIsbn(@PathVariable Long id) {
        return bookDtoMapper.toDto(bookService.getByIsbnId(id));
    }

}
