package io.github.wotjd243.aladin.reservation.domain;

public interface ReservationRepository {

    long countByBuyerId(Long buyerId);

    void save(Reservation reservation);
}
