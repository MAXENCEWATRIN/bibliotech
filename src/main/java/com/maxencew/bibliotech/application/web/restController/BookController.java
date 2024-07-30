package com.maxencew.bibliotech.application.web.restController;

import com.maxencew.bibliotech.application.mapper.dto.BookDtoMapper;
import com.maxencew.bibliotech.application.request.BookRequest;
import com.maxencew.bibliotech.application.response.BibliotechHttpResponse;
import com.maxencew.bibliotech.application.response.BookResponse;
import com.maxencew.bibliotech.domain.ports.api.BookConsumer;
import com.maxencew.bibliotech.domain.ports.api.BookProducer;
import com.maxencew.bibliotech.domain.ports.api.BookService;
import com.maxencew.bibliotech.domain.ports.api.ImageService;
import com.maxencew.bibliotech.domain.model.Book;
import com.maxencew.bibliotech.infrastructure.dto.BookConsumerMessage;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private BookProducer bookProducer;
    @Autowired
    private ImageService imageDownloaderService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private BookDtoMapper bookDtoMapper;

    @PostMapping
    public BibliotechHttpResponse<BookResponse> addBook(@Valid @RequestBody BookRequest book) {
        return BibliotechHttpResponse.success(bookDtoMapper.toDto(bookServiceAdapter.addBook(bookDtoMapper.toDomain(book))));
    }

    @PutMapping("/{id}")
    public BibliotechHttpResponse<BookResponse> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequest book) {
        book.setId(id);
        return BibliotechHttpResponse.success(bookDtoMapper.toDto(bookServiceAdapter.addBook(bookDtoMapper.toDomain(book))));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id, @RequestBody BookRequest book) {
        book.setId(id);
        bookServiceAdapter.removeBook(bookDtoMapper.toDomain(book));
    }

    @GetMapping
    public BibliotechHttpResponse<List<BookResponse>> getAllBooks() {
        return BibliotechHttpResponse.success(bookDtoMapper.toDtoList(bookServiceAdapter.getBooks()));
    }

    @GetMapping("/{id}")
    public BibliotechHttpResponse<BookResponse> getBookById(@PathVariable Long id) {
        BookResponse dto = bookDtoMapper.toDto(bookServiceAdapter.getBookById(id));
        return BibliotechHttpResponse.success(dto);
    }

    @GetMapping("isbn/{id}")
    public void getBookByIsbn(@PathVariable Long id) {
        BibliotechHttpResponse<BookResponse> success = BibliotechHttpResponse.success(bookDtoMapper.toDto(bookServiceAdapter.getByIsbnId(id)));
        simpMessagingTemplate.convertAndSend("/topic/books", success);
    }

    @PostMapping("/isbn")
    public ResponseEntity<BibliotechHttpResponse<BookConsumerMessage>> processBookInit(@RequestBody BookConsumerMessage isbnIdBookRequest) {
        bookProducer.handleBook(isbnIdBookRequest);
        return new ResponseEntity<>(BibliotechHttpResponse.success(isbnIdBookRequest), HttpStatus.ACCEPTED);
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
