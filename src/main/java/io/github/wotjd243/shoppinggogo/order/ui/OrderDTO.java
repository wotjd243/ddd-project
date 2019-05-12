package io.github.wotjd243.shoppinggogo.order.ui;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class OrderDTO {
    private long userId;
    private ArrayList<Long> selectedProducts;

}
