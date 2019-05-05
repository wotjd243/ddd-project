package io.github.wotjd243.aladin.reservationbook.domain;

import io.github.wotjd243.aladin.registeredbook.domain.RegisteredBook;
import io.github.wotjd243.aladin.shoppingbasket.domain.ShoppingBasket;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ReservationBook {

    private Long id;

    private ShoppingBasket shoppingBasket;

    private RegisteredBook registeredBook;

    private LocalDateTime reservationDateTime;

    public ReservationBook(ShoppingBasket shoppingBasket, RegisteredBook registeredBook) {

        this.id = UUID.randomUUID().getMostSignificantBits();
        this.shoppingBasket = shoppingBasket;
        this.registeredBook = registeredBook;
        this.reservationDateTime = LocalDateTime.now();
    }
}
