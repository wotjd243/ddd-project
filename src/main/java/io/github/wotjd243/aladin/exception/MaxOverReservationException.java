package io.github.wotjd243.aladin.exception;

import io.github.wotjd243.aladin.error.ErrorCode;

public class MaxOverReservationException extends BusinessException {

    public MaxOverReservationException(String message) {

        super(ErrorCode.MAX_OVER_RESERVATION, message);
    }
}
