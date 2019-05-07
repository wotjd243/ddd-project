package io.github.wotjd243.aladin.exception;

import io.github.wotjd243.aladin.error.ErrorCode;

public class TypeMissMatchException extends BusinessException {

    public TypeMissMatchException(String message) {

        super(ErrorCode.INVALID_TYPE_VALUE, message);
    }
}
