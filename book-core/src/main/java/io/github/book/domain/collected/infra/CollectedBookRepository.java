package io.github.book.domain.collected.infra;

import io.github.book.domain.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectedBookRepository extends JpaRepository<Book, Long> {

}
