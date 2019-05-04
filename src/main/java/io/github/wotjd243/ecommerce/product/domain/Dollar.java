package io.github.wotjd243.ecommerce.product.domain;

public class Dollar {
    private double price;

    public Dollar(Double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Dollar의 값은 음수일 수 없습니다.");
        }

        this.price = price;
    }

    public double castToDouble() {
        return this.price;
    }

    public boolean equals(double price) {
        return Double.compare(price, this.price) == 0;
    }
}
