package io.github.wotjd243.ecommerce.order.domain;

import io.github.wotjd243.ecommerce.product.domain.Dollar;
import io.github.wotjd243.ecommerce.product.domain.Item;
import io.github.wotjd243.ecommerce.user.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date orderDate;
    private String orderId;
    private User user;
    private Paymethod paymethod;
    private List<Item> itemList;
    private double totalPrice;

    public Order(String orderId, User user, Paymethod paymethod, List<Item> itemList) {
        this.orderId = orderId;
        this.user = user;
        this.paymethod = paymethod;
        this.itemList = itemList;
        computeTotalPrice(itemList);
    }

    private void computeTotalPrice(List<Item> items) {

        for (Item item: items) {
            this.totalPrice = Double.sum(item.price(), this.totalPrice);
        }
    }


}
