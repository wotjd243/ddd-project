package io.github.wotjd243.aladin.enrollment.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {

    private LocalDate startDate;

    private LocalDate endDate;

    private Double periodPercent;

    public Event(LocalDate startDate, LocalDate endDate, Double periodPercent) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.periodPercent = periodPercent;
    }
}
