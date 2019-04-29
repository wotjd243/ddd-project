package io.github.wotjd243.ecommerce.buyer.domain;

import java.util.Date;

public class ItemOrder {
    private int quntitly;
    private double unitPrice;   // 물품의 단가
    private Date orderDate;     // 구매일
    private String payMethod;   // 구매수단 (Card, Hpp)

    public ItemOrder(int quntitly, double unitPrice, String payMethod) {
        this.quntitly = quntitly;
        this.unitPrice = unitPrice;
        this.payMethod = payMethod;
        this.orderDate = new Date();
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuntitly() {
        return quntitly;
    }

}
