package io.github.wotjd243.ecommerce.buyer.domain;

import java.util.Date;

public class Buyer {
    private int buyerId;        // 구매자아이디
    private String address;     // 구매자주소
    private double totalPrice;  // 구매한 총합
    private Order order;

    public Buyer(int buyerId, String address, double totalPrice) {
        this.buyerId = buyerId;
        this.address = address;
        this.totalPrice = totalPrice;
        this.order = new Order();
    }

    public void computeTotalPrice(ItemOrder itemOrder) {
        this.totalPrice += itemOrder.getUnitPrice() * itemOrder.getQuntitly();
    }

    public void addOrder(ItemOrder itemOrder) {
        this.order.add(itemOrder);
        computeTotalPrice(itemOrder);
    }

}
