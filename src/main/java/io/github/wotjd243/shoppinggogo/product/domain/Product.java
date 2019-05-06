package io.github.wotjd243.shoppinggogo.product.domain;


import lombok.Data;
import lombok.Getter;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Data
public class Product {
    @Getter
    private Long id; //상품 ID
    private String name; //상품 명
    private Category category; //상품 카테고리
    private ProductImage productImage; //제품 이미지
    private List<PriceRecord> prices;
    private Date createDate; // 생성 날짜
    private Date updateDate; //수정된 날짜

    public Product(Long id, String name, Category category, ProductImage productImage,
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
     * @return
     */
    public PriceRecord findLowestPrice() {
        return prices.stream().min(Comparator.comparing(PriceRecord::getLowestPrice))
                .orElseThrow(NoSuchElementException::new);
    }

}
