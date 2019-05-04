package io.github.wotjd243.ecommerce.product.domain;

import java.net.MalformedURLException;
import java.net.URL;

public class Item {
    private String title;
    private Dollar price;
    private URL galleryUrl;
    private SellingState sellingState;

    public Item(String title, Double price, String galleryUrl) {
        this.title = title;
        this.price = new Dollar(price);
        setGalleryUrl(galleryUrl);

        this.sellingState = SellingState.ACTIVE;
    }

    public boolean isActive() {
        return sellingState.isActive();
    }

    public boolean isSamePrice(double price) {
        return this.price.equals(price);
    }

    public boolean match(String keywords) {
        return title.contains(keywords);
    }

    public double price() {
        return this.price.castToDouble();
    }

    private void setGalleryUrl(String galleryUrl) {
        try {
            this.galleryUrl = new URL(galleryUrl);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    enum SellingState {
        ACTIVE("Active"),
        CANCELED("Canceled"),
        ENDED("Ended"),
        ENDED_WITH_SALES("EndedWithSales"),
        ENDED_WITHOUT_SALES("EndedWithoutSales");

        private final String value;

        SellingState(String value) {
            this.value = value;
        }

        private boolean isActive() {
            return (this == ACTIVE);
        }
    }
}
