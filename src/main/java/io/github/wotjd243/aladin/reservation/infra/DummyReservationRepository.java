package io.github.wotjd243.aladin.reservation.infra;

import io.github.wotjd243.aladin.reservation.domain.Reservation;
import io.github.wotjd243.aladin.reservation.domain.ReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DummyReservationRepository implements ReservationRepository {

    @Override
    public long countByBuyerId(Long buyerId) {

        return DummyReservationData.size(buyerId);
    }

    @Override
    public void save(Reservation reservation) {

        DummyReservationData.put(reservation);
    }
}
