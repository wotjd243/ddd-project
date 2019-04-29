package io.github.wotjd243.ecommerce.product.domain;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private long id = 1L;
    private String name;
    private List<Item> items = new ArrayList();

    public Product(String name) {
        this.name = name;
    }

    public void register(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
