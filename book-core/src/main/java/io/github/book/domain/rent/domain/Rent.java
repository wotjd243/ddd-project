package io.github.book.domain.rent.domain;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
public class Rent {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDateTime rentStartDatetime;

    @Column(nullable = false)
    private LocalDateTime returnDatetime;

    @Column(nullable = false)
    private LocalDateTime returnDeadLine;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long collectedBookId;
}
