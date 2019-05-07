package io.github.wotjd243.aladin.reservation.infra;

import io.github.wotjd243.aladin.reservation.domain.Reservation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DummyReservationData {

    private static final Map<Long, Reservation> enrollmentGroup = new HashMap<>();

    public static Reservation put(Reservation reservation) {
        return enrollmentGroup.put(reservation.getId(), reservation);
    }

    public static long size(Long buyerId) {
        return enrollmentGroup.values()
                .stream()
                .map(Reservation::getBuyerId)
                .filter(buyerId::equals)
                .count();
    }

    public static Optional<Reservation> get(Long id) {
        return Optional.of(enrollmentGroup.get(id));
    }

}
