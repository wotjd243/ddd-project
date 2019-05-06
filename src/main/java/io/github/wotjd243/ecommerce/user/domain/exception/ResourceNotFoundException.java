package io.github.wotjd243.ecommerce.user.domain.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String messages) {
        super(messages);
    }
}
