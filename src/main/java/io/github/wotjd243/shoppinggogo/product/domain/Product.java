package io.github.wotjd243.shoppinggogo.product.domain;


import java.util.Date;
import java.util.List;


public class Product {
    private long id; //상품 ID
    private String name; //상품 명
    private Category category; //상품 카테고리
    private ProductImage productImage; //제품 이미지
    private List<PriceRecord> prices;
    private Date createDate; // 생성 날짜
    private Date updateDate; //수정된 날짜

    public Product(long id, String name, Category category, ProductImage productImage,
           List<PriceRecord> prices, Date createDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.productImage = productImage;
        this.prices = prices;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    /**
     * 제품 가장 낮은 가격을 조회한다.
     * @param prices
     */
    public void findLowestPrice(List<PriceRecord> prices) {


    }

}
