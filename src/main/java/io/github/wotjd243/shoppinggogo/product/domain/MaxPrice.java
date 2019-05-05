package io.github.wotjd243.shoppinggogo.product.domain;

public class MaxPrice implements Price{

    private int value;

    public MaxPrice(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
