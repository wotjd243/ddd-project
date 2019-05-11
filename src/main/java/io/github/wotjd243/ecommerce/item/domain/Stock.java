package io.github.wotjd243.ecommerce.item.domain;

public class Stock {
    private static final int MIN_STOCK = 0;

    private int value;

    public Stock(int initialValue) {
        if (initialValue < MIN_STOCK) {
            throw new IllegalArgumentException();
        }

        this.value = initialValue;
    }

    int getValue() {
        return value;
    }

    Stock decrease(int numberOfDecrement) {
        validateStock(numberOfDecrement);

        this.value -= numberOfDecrement;
        return this;
    }

    boolean isOutOfStock() {
        return (this.value == 0);
    }

    private void validateStock(int numberOfSoldItem) {
        if ((this.value - numberOfSoldItem) < MIN_STOCK) {
            throw new IllegalStateException();
        }
    }
}
