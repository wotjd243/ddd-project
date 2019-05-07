package io.github.wotjd243.aladin.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Getter
@RequiredArgsConstructor
public class ErrorMessage {

    private final String field;
    private final String message;

    public static ErrorMessage of(FieldError fieldError) {

        return new ErrorMessage(fieldError.getField(), fieldError.getDefaultMessage());
    }

    public static ErrorMessage of(ObjectError objectError) {

        return new ErrorMessage(objectError.getObjectName(), objectError.getDefaultMessage());
    }
}
