package io.github.wotjd243.shoppinggogo.shipping.domain;

import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class Shipping implements Serializable {
    // 배송번호
    private Long id;
    // 배송상태( 물건준비중, 집하, 배송중(입고),  배달중, 배달완료 )
    private String shippingStatus;
    // 물건 리스트,주소,배송비( 주문에서 가져옴 될듯 ? )
    private String orderId;
    // 현재 위치 ( 어느 센터 인지 ) - history로 해줘야함
    //현재위치
    private String position;
    // 처리일시
    private Date ProcessedDate;
    // 송장정보 ( 송장정보, 택배사, 대표번호 )
    private Invoice Invoice;
    // 판매자 ( 개밥왕, 연락처 )
    private Seller seller;

    public Shipping( Long id, String shippingStatus, String orderId, String position, Date processedDate,
                    Invoice invoice, Seller seller) {
        this.id = id;
        this.shippingStatus = shippingStatus;
        this.orderId = orderId;
        this.position = position;
        this.ProcessedDate = processedDate;
        this.Invoice = invoice;
        this.seller = seller;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }
}
