package io.github.wotjd243.ecommerce.buyer.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private List<ItemOrder> orderItems;

    public boolean isEmpty() {
        return (this.orderItems == null || orderItems.isEmpty());
    }

    public void add(ItemOrder itemOrder) {
        if (isEmpty()) {
            this.orderItems = new ArrayList<>();
        }
        this.orderItems.add(itemOrder);
    }


}
