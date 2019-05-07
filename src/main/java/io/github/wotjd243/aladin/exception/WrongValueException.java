package io.github.wotjd243.aladin.exception;

import io.github.wotjd243.aladin.error.ErrorCode;

public class WrongValueException extends BusinessException {

    public WrongValueException(String message) {
        super(ErrorCode.INVALID_INPUT_VALUE, message);
    }
}
