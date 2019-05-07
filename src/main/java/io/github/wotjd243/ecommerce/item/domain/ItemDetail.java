package io.github.wotjd243.ecommerce.item.domain;

import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;

import java.net.MalformedURLException;
import java.net.URL;

public class ItemDetail {
    private String title;
    private Dollar price;
    private URL galleryUrl;

    public ItemDetail(String title, Double price, String galleryUrl) {
        this.title = title;
        this.price = new Dollar(price);
        setGalleryUrl(galleryUrl);
    }

    private void setGalleryUrl(String galleryUrl) {
        try {
            this.galleryUrl = new URL(galleryUrl);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean contains(QueryKeyword keywords) {
        return keywords.match(title);
    }

    public String getTitle() {
        return title;
    }

    public String getGalleryUrl() {
        return galleryUrl.toString();
    }

    public double getPrice() {
        return price.getPrice();
    }
}
