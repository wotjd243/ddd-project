package io.github.book.domain.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class BookRentHistory {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime rentStartDatetime;
    private LocalDateTime returnDatetime;
    private LocalDateTime returnDeadLine;
}
