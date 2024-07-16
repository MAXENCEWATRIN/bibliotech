package com.maxencew.biblioto.application.web.restController;

import com.maxencew.biblioto.application.mapper.dto.BookDtoMapper;
import com.maxencew.biblioto.application.request.BookRequest;
import com.maxencew.biblioto.application.response.BibliotoHttpResponse;
import com.maxencew.biblioto.application.response.BookResponse;
import com.maxencew.biblioto.application.service.api.BookService;
import com.maxencew.biblioto.application.service.api.ImageService;
import com.maxencew.biblioto.domain.model.Book;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookServiceAdapter;
    @Autowired
    private ImageService imageDownloaderService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private BookDtoMapper bookDtoMapper;

    @PostMapping
    public BibliotoHttpResponse<BookResponse> addBook(@Valid @RequestBody BookRequest book) {
        return BibliotoHttpResponse.success(bookDtoMapper.toDto(bookServiceAdapter.addBook(bookDtoMapper.toDomain(book))));
    }

    @PutMapping("/{id}")
    public BibliotoHttpResponse<BookResponse> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequest book) {
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
    public void getBookByIsbn(@PathVariable Long id) {
        BibliotoHttpResponse<BookResponse> success = BibliotoHttpResponse.success(bookDtoMapper.toDto(bookServiceAdapter.getByIsbnId(id)));
        simpMessagingTemplate.convertAndSend("/topic/books", success);
    }

    @GetMapping("/{id}/cover")
    public ResponseEntity<byte[]> getBookCover(@PathVariable Long id) {
        Book book = bookServiceAdapter.getBookById(id);
        if (book.getCoverImageId() == null) {
            return ResponseEntity.notFound().build();
        }
        byte[] image = imageDownloaderService.getImageById(book.getCoverImageId());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

}
