package io.github.book.rent.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Rent {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDateTime rentStartDatetime;

    @Column
    private LocalDateTime returnDatetime;

    @Column(nullable = false)
    private LocalDateTime returnDeadLine;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long collectedBookId;

    @Builder
    public Rent(Long userId, Long collectedBookId) {
        this.rentStartDatetime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        this.returnDeadLine = rentStartDatetime.plusWeeks(2L);
        this.userId = userId;
        this.collectedBookId = collectedBookId;
    }
}
