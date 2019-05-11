package io.github.wotjd243.ecommerce.item.domain;

public class Dollar {
    private double price;

    public Dollar(Double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Dollar의 값은 음수일 수 없습니다.");
        }

        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public Double multiple(int quantity) {
        return price * quantity;
    }
}
