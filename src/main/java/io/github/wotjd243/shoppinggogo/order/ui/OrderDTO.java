package io.github.wotjd243.shoppinggogo.order.ui;

import java.util.ArrayList;

public class OrderDTO {
    private long userId;
    private ArrayList<Long> selectedProducts;

    public long getUserId() {
        return userId;
    }

    public ArrayList<Long> getSelectedProducts() {
        return selectedProducts;
    }
}
