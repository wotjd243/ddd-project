package io.github.wotjd243.shoppinggogo.cart.domain;

import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.user.domain.User;

import java.util.List;

public class Cart {
    private String id;
    private User user;
    private List<String> productList;

    public Cart(String id, User user, List<String> productList) {
        this.id = id;
        this.user = user;
        this.productList = productList;
    }

}
