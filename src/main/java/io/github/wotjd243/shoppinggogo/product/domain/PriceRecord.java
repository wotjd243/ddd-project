package io.github.wotjd243.shoppinggogo.product.domain;

import lombok.Getter;

import java.util.Date;

public class PriceRecord {
    private Long id; //ID
    @Getter
    private Integer lowestPrice; //가장 낮은 가격
    private Integer highestPrice; //가장 높은 가격
    private Integer retailPrice; //소매가 가격
    private Date createDate; //생성 날짜
    private Date updateDate; //변경 날짜

    public PriceRecord(Long id, Integer lowestPrice, Integer highestPrice, Integer retailPrice,
                       Date createDate, Date updateDate) {
        this.id = id;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.retailPrice = retailPrice;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Integer getLowestPrice() {
        return lowestPrice;
    }
}
