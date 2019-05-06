package io.github.book.domain.book.infra;

import io.github.book.domain.book.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummyBookRepository {
    public Optional<Book> findByIsbn(String isbn){
        return Optional.ofNullable(DummyBookData.get(isbn));
    }

    public Optional<Book> findByTitleContains(String title){
        return DummyBookData.findByTitle(title);
    }
}
