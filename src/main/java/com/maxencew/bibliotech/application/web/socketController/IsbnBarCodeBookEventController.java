package com.maxencew.bibliotech.application.web.socketController;

import com.maxencew.bibliotech.application.response.BookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
@Slf4j
public class IsbnBarCodeBookEventController {
    @MessageMapping("/book")
    @SendTo("/topic/books")
    public BookResponse sendBookEvent(BookResponse book) {
        LOGGER.info("Alors t'en penses quoi ??");
        return book;
    }
}
