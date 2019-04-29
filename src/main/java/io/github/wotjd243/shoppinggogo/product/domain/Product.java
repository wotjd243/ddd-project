package io.github.wotjd243.shoppinggogo.product.domain;

public class Product {
    private String id;
    private String name;
    private int lowestPrice;
    private int highestPrice;
    private String mall;
    private String imageLink;

    public Product(String id, String name, int lowestPrice, int highestPrice, String mall, String imageLink) {
        this.id = id;
        this.name = name;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.mall = mall;
        this.imageLink = imageLink;
    }
}
