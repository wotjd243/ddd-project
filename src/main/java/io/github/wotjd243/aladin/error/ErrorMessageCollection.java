package io.github.wotjd243.aladin.error;

import lombok.Getter;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ErrorMessageCollection {

    private List<ErrorMessage> errors = new ArrayList<>();

    public ErrorMessageCollection(List<FieldError> fieldErrors, List<ObjectError> globalErrors) {
        errors.addAll(getFieldErrors(fieldErrors));
        errors.addAll(getObjectErrors(globalErrors));
    }

    public ErrorMessageCollection(List<ErrorMessage> errors) {
        this.errors = errors;
    }

    private List<ErrorMessage> getFieldErrors(List<FieldError> fieldErrors) {
        return fieldErrors.stream()
                .map(ErrorMessage::of)
                .collect(Collectors.toList());
    }

    private List<ErrorMessage> getObjectErrors(List<ObjectError> globalErrors) {
        return globalErrors.stream()
                .map(ErrorMessage::of)
                .collect(Collectors.toList());
    }
}
