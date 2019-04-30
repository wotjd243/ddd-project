package io.github.book.domain.book;

import lombok.Builder;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
public class BookRentHistory {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime rentStartDatetime;
    private LocalDateTime returnDatetime;
    private LocalDateTime returnDeadLine;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
