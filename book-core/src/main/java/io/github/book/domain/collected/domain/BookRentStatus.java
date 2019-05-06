package io.github.book.domain.collected.domain;


public enum BookRentStatus {
    RENT_ALREADY, RENT_AVAILABLE;

    public boolean isRent() {
        return this == RENT_AVAILABLE;
    }
}
