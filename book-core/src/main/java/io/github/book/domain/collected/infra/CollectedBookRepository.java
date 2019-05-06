package io.github.book.domain.collected.infra;

import io.github.book.domain.collected.domain.BookRentStatus;
import io.github.book.domain.collected.domain.CollectedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CollectedBookRepository extends JpaRepository<CollectedBook, Long> {
    Optional<List<CollectedBook>> findByBookRentStatus(BookRentStatus bookRentStatus);
}
