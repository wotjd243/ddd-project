package io.github.wotjd243.aladin.reservation.domain;

import lombok.Getter;

@Getter
public class Reservation {

    private Long id;

    private Long buyerId;

    private Long registeredBookId;

    public Reservation(Long buyerId, Long registeredBookId) {

        this.buyerId = buyerId;
        this.registeredBookId = registeredBookId;
    }
}
