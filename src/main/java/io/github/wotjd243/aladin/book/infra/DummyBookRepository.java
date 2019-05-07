package io.github.wotjd243.aladin.book.infra;

import io.github.wotjd243.aladin.book.domain.Book;
import io.github.wotjd243.aladin.book.domain.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummyBookRepository implements BookRepository {

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(DummyBookData.get(id));
    }
}
