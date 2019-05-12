package io.github.book.book.application;

import io.github.book.book.application.dto.BookDto;
import io.github.book.book.domain.Book;
import io.github.book.book.infra.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    public Page<Book> readBook(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new NoSuchElementException("그런 책 없어요;;"));
    }

    @Transactional
    public Book saveBook(BookDto bookDto) {
        Book book = Book.builder()
                .author(bookDto.getAuthor())
                .description(bookDto.getDescription())
                .title(bookDto.getTitle())
                .isbn(bookDto.getIsbn())
                .publishedDate(bookDto.getPublishedDate())
                .build();
        return bookRepository.save(book);
    }
}
