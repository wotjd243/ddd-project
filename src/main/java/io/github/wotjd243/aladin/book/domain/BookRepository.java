package io.github.wotjd243.aladin.book.domain;

import java.util.Optional;

public interface BookRepository {

    Optional<Book> findById(Long id);

}
