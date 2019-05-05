package io.github.wotjd243.aladin.shoppingbasket.domain;

import io.github.wotjd243.aladin.enrollment.domain.UnitAmount;
import io.github.wotjd243.aladin.exception.AlreadyBoundException;
import io.github.wotjd243.aladin.registeredbook.domain.RegisteredBook;
import io.github.wotjd243.aladin.reservationbook.domain.ReservationBook;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShoppingBasket {

    private static final Integer ENABLE_COUNT = 15;

    private Long id;

    private Long buyerId; // 보통 Buyer 로 하는데 수업에서 일단 id로 하라고 하니...

    private List<ReservationBook> reservationBooks = new ArrayList<>();

    public void add(RegisteredBook registeredBook) {

        if (reservationBooks.stream().map(ReservationBook::getRegisteredBook)
                .anyMatch(registeredBook::equalsBook)) {

            throw new AlreadyBoundException("이미 찜한 책입니다.");
        }

        if (reservationBooks.size() >= ENABLE_COUNT) {

            throw new IllegalStateException("찜한 책의 총합은 15권을 넘지 못합니다.");
        }

        reservationBooks.add(new ReservationBook(this, registeredBook));
    }

    public long getCount() {
        return reservationBooks.size();
    }

    public long getAmount() {
        return reservationBooks.stream()
                .map(ReservationBook::getRegisteredBook)
                .map(RegisteredBook::getAmount)
                .map(UnitAmount::getAmount)
                .reduce(0L, Long::sum);
    }

    public long computeAmount() {

        return deliveryAmount();
    }

    private long deliveryAmount() {

        if (getCount() <= 3) {
            return 2500;
        }

        return 0;
    }

//
//    private List<RegisteredBook>
}
