package io.github.wotjd243.shoppinggogo.product.domain;

import java.util.List;

public class Product {
    private String id;
    private String name;
    private List<Price> price;
    private String mall;
    private String imageLink;

    public Product(String id, String name, Price price, String mall, String imageLink) {
        this.id = id;
        this.name = name;
        this.mall = mall;
        this.imageLink = imageLink;
    }
}
