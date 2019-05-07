package io.github.wotjd243.aladin.enrollment.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Enrollment {

    private Long id;

    private Long sellerId;

    private Event event;

    private UnitAmount amount;

    private List<RegisteredBook> registeredBooks = new ArrayList<>();

    private Enrollment(Long sellerId, Long bookId, Long count, Long unitAmount, Event event) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.sellerId = sellerId;
        this.event = event;
        this.amount = new UnitAmount(unitAmount);
        generateBooks(bookId, new Count(count));
    }

    public static Enrollment of(Long sellerId, Long bookId, Long count, Long unitAmount) {
        return new Enrollment(sellerId, bookId, count, unitAmount, new Event());
    }

    public static Enrollment ofWithEvent(Long sellerId, Long bookId, Long count, Long unitAmount, LocalDate startDate, LocalDate endDate, Double periodPercent) {
        return new Enrollment(sellerId, bookId, count, unitAmount, new Event(startDate, endDate, periodPercent));
    }

    private void generateBooks(Long bookId, Count count) {

        for (long i = 0, length = count.getCount(); i < length; i++) {
            addRegisteredBook(new RegisteredBook(bookId));
        }
    }

    private void addRegisteredBook(RegisteredBook registeredBook) {
        registeredBooks.add(registeredBook);
    }
}
