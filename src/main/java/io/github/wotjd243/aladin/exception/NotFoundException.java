package io.github.wotjd243.aladin.exception;

import io.github.wotjd243.aladin.error.ErrorCode;

public class NotFoundException extends BusinessException {

    public NotFoundException(String message) {
        super(ErrorCode.ENTITY_NOT_FOUND, message);
    }
}
