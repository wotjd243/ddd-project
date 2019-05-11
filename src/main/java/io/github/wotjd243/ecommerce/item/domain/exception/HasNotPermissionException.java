package io.github.wotjd243.ecommerce.item.domain.exception;

public class HasNotPermissionException extends RuntimeException {
    public HasNotPermissionException(String messages) {
        super(messages);
    }
}
