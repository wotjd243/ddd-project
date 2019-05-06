package io.github.book.domain.rent.infra;

import io.github.book.domain.rent.domain.BookRentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRentHistoryRepository extends JpaRepository<BookRentHistory, Long> {
}
