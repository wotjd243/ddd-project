package io.github.wotjd243.ecommerce.item.domain;

public enum ItemState {
    BEFORE_SELLING,
    SELLING,
    SOLD_OUT;

    boolean isSelling() {
        return (this == SELLING);
    }
}
