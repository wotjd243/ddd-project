package io.github.wotjd243.shoppinggogo.product.domain;

import java.util.Date;

public class PriceRecord {
    private long id; //ID
    private int lowestPrice; //가장 낮은 가격
    private int highestPrice; //가장 높은 가격
    private int retailPrice; //소매가 가격
    private Date createDate; //생성 날짜
    private Date updateDate; //변경 날짜

    public PriceRecord(long id, int lowestPrice, int highestPrice, int retailPrice,
                       Date createDate, Date updateDate) {
        this.id = id;
        this.lowestPrice = lowestPrice;
        this.highestPrice = highestPrice;
        this.retailPrice = retailPrice;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


}
