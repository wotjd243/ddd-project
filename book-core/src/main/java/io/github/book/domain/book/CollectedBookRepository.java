package io.github.book.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectedBookRepository extends JpaRepository<CollectedBook, Long> {
}
