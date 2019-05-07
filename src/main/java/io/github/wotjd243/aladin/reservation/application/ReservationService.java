package io.github.wotjd243.aladin.reservation.application;

import io.github.wotjd243.aladin.exception.MaxOverReservationException;
import io.github.wotjd243.aladin.registeredbook.domain.RegisteredBook;
import io.github.wotjd243.aladin.reservation.domain.Reservation;
import io.github.wotjd243.aladin.reservation.domain.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    public static final int LIMIT_RESERVATION_COUNT = 15;
    private final ReservationRepository reservationRepository;

    public void add(Long buyerId, Long registeredBookId) {

        enableReservation(buyerId);
        reserveBook(registeredBookId);

        save(new Reservation(buyerId, registeredBookId));
    }

    private void reserveBook(Long registeredBookId) {
        RegisteredBook registeredBook = findRegisteredBookId(registeredBookId);
        // 등록된 책을 찜하는 기능
    }

    private void save(Reservation reservation) {

        reservationRepository.save(reservation);
    }

    /**
     * todo Id를 가지고 등록된 책을 찾는다.
     */
    private RegisteredBook findRegisteredBookId(Long registeredBookId) {

        return null;
    }

    private void enableReservation(Long buyerId) {

        if (reservationRepository.countByBuyerId(buyerId) >= LIMIT_RESERVATION_COUNT) {
            throw new MaxOverReservationException(String.format("최대 %s 권을 찜할 수 있습니다.", LIMIT_RESERVATION_COUNT));
        }
    }
}
