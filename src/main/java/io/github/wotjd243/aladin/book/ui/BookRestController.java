package io.github.wotjd243.aladin.book.ui;

import io.github.wotjd243.aladin.book.application.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    final private BookService bookService;

    @GetMapping(value = "/book/{id}")
    public boolean isExist(@PathVariable Long id) {
        return bookService.isExist(id);
    }

}
