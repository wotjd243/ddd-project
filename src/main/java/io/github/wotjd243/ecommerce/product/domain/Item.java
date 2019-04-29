package io.github.wotjd243.ecommerce.product.domain;

import java.net.URL;

public class Item {

    private String title;                   // 물품의 이름
    private Double price;                   // 물품의 가격(현재가)
    private URL galleryUrl;              // 물품의 이미지URL
    private SellingState sellingState;            // 판매상태 (Active, Canceled, Ended, EndedWithSales, EndedWithoutSales)

    public Item(String title, Double price, URL galleryUrl, SellingState sellingState) {
        this.title = title;
        this.price = price;
        this.galleryUrl = galleryUrl;
        this.sellingState = sellingState;
    }

    public boolean isActive() {
        return sellingState.match(SellingState.ACTIVE);
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
