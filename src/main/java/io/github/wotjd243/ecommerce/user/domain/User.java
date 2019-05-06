package io.github.wotjd243.ecommerce.user.domain;

import io.github.wotjd243.ecommerce.product.domain.Item;
import io.github.wotjd243.ecommerce.product.domain.Product;

import java.util.List;

public class User {

    private String id;

    private String address;

    private ShippingAddresses shippingAddresses;

    public User(String id, String address) {
        this.id = id;
        this.address = address;
    }

    public void registerGoods(Product product, Item item) {
        product.register(item);
    }

    public List<Item> retrieve(Product product) {
        return product.getItems();
    }
}
