package io.github.book.domain.history.domain;

import io.github.book.domain.book.domain.Book;
import io.github.book.domain.user.domain.User;
import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
public class BookRentHistory {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDateTime rentStartDatetime;

    @Column(nullable = false)
    private LocalDateTime returnDatetime;

    @Column(nullable = false)
    private LocalDateTime returnDeadLine;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private Book book;
}
