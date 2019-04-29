package io.github.wotjd243.ecommerce.Item.domain;

public class Item {

    private String title;                   // 물품의 이름
    private Double price;                   // 물품의 가격(현재가)
    private String galleryUrl;              // 물품의 이미지URL
    private String sellingState;            // 판매상태 (Active, Canceled, Ended, EndedWithSales, EndedWithoutSales)

    public Item(String title, Double price, String galleryUrl, String sellingState) {
        this.title = title;
        this.price = price;
        this.galleryUrl = galleryUrl;
        this.sellingState = sellingState;
    }
}
