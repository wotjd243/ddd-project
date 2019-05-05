package io.github.wotjd243.aladin.enrollment.domain;

import io.github.wotjd243.aladin.book.domain.Book;
import io.github.wotjd243.aladin.registeredbook.domain.RegisteredBook;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Enrollment {

    private Long id;

    private Long sellerId; // 보통 Seller 로 하는데 수업에서 일단 id로 하라고 하니...

    private Event event;

    private List<RegisteredBook> registeredBooks = new ArrayList<>();

    private Enrollment(Long sellerId, Book book, Long count, Long unitAmount, Event event) {
        this.id = UUID.randomUUID().getMostSignificantBits();
        this.sellerId = sellerId;
        this.event = event;
        generateBooks(book, new Count(count), new UnitAmount(unitAmount));
    }

    public static Enrollment of(Long sellerId, Book book, Long count, Long unitAmount) {
        return new Enrollment(sellerId, book, count, unitAmount, new Event());
    }

    public static Enrollment ofWithEvent(Long sellerId, Book book, Long count, Long unitAmount, LocalDate startDate, LocalDate endDate, Double periodPercent) {
        return new Enrollment(sellerId, book, count, unitAmount, new Event(startDate, endDate, periodPercent));
    }

    private void generateBooks(Book book, Count count, UnitAmount unitAmount) {

        for (long i = 0, length = count.getCount(); i < length; i++) {
            addRegisteredBook(new RegisteredBook(book, unitAmount));
        }
    }

    private void addRegisteredBook(RegisteredBook registeredBook) {
        registeredBooks.add(registeredBook);
    }
}
