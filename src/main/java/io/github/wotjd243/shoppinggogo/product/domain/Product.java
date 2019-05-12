package io.github.wotjd243.shoppinggogo.product.domain;


import java.util.Date;


public class Product {
    private Long id; //상품 ID
    private String name; //상품 명
    private Category category; //상품 카테고리
    private ProductImage productImage; //제품 이미지
    private PriceRecord prices;

    private Date createDate; // 생성 날짜
    private Date updateDate; //수정된 날짜

    public Product(Long id, String name, Category category, ProductImage productImage,
           PriceRecord prices, Date createDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.productImage = productImage;
        this.prices = prices;
    }

    /**
     * 제품 가장 낮은 가격을 조회한다.
     * @return
     */
    public int findLowestPrice() {
        return prices.getLowestPrice();
    }


    public Long getId() {
        return id;
    }


}
