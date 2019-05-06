package io.github.wotjd243.ecommerce.order.domain;

import io.github.wotjd243.ecommerce.item.domain.Dollar;

import java.net.URL;

//TODO: ItemDetail로 변경
public class ConsideringItem {
    private String title;
    private Dollar price;
    private URL galleryUrl;
    private int quantity;

    public ConsideringItem(String title, Dollar price, URL galleryUrl, int quantity) {
        this.title = title;
        this.price = price;
        this.galleryUrl = galleryUrl;
        this.quantity = quantity;
    }

    public Double sum() {
        return this.price.multiple(quantity);
    }

    public String getTitle() {
        return title;
    }
}
