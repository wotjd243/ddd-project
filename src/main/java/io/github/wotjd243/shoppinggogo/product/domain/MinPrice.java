package io.github.wotjd243.shoppinggogo.product.domain;

public class MinPrice implements Price {
    private int value;
    public MinPrice(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
