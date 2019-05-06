package io.github.wotjd243.shoppinggogo.product.domain;

import java.util.Date;

public class ProductImage {
    private long id;
    private long productId; //제품 아이디
    private String imageLink; //이미지 링크
    private String imageFile; //이미지 파일
    private Date modifyDate; //수정된 날짜

    public ProductImage(long id, long productId, String imageLink, String imageFile, Date modifyDate) {
        this.id = id;
        this.productId = productId;
        this.imageLink = imageLink;
        this.imageFile = imageFile;
        this.modifyDate = modifyDate;
    }
}
