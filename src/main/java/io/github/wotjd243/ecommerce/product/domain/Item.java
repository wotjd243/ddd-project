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

        try {
            this.galleryUrl = new URL(galleryUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        this.sellingState = SellingState.ACTIVE;
    }

    public boolean isActive() {
        return sellingState.match(SellingState.ACTIVE);
    }

    public boolean isSamePrice(double price) {
        return this.price.equals(price);
    }

    public boolean match(String keywords) {
        return title.contains(keywords);
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

        private String value;

        private boolean match(SellingState state) {
            return this.value == state.value;
        }

        SellingState(String value) {
            this.value = value;
        }
    }
}
