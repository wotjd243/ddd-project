package io.github.book.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRentHistoryRepository extends JpaRepository<BookRentHistory, Long> {
}
