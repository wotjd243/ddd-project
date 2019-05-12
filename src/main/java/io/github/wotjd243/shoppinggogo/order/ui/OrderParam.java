package io.github.wotjd243.shoppinggogo.order.ui;

import lombok.Getter;

import java.util.ArrayList;

public class OrderParam {
    private Long userId;
    private ArrayList<Long> selectedProducts;

    public Long getUserId() {
        return userId;
    }
//
    public ArrayList<Long> getSelectedProducts() {
        return selectedProducts;
    }
}
