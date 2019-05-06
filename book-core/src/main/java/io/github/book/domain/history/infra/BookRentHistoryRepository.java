package io.github.book.domain.history.infra;

import io.github.book.domain.history.domain.BookRentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRentHistoryRepository extends JpaRepository<BookRentHistory, Long> {
}
