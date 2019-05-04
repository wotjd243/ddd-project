package io.github.book.domain.book;

import io.github.book.domain.user.User;
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
    @JoinColumn(name = "book_id")
    private Book book;
}
