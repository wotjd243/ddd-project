package io.github.wotjd243.shoppinggogo.shipping.domain;

import java.util.Date;

public class ShippingDetailInfo {

    // 배송상태( 물건준비중, 집하, 배송중(입고),  배달중, 배달완료 )
    private String shippingStatus;
    // 물건 리스트,주소,배송비( 주문에서 가져옴 될듯 ? )
    private String orderId;
    // 현재 위치 ( 어느 센터 인지 ) - history로 해줘야함
    //현재위치
    private String position;
    // 처리일시
    private Date ProcessedDate;

    public ShippingDetailInfo(String shippingStatus, String orderId, String position, Date processedDate) {
        this.shippingStatus = shippingStatus;
        this.orderId = orderId;
        this.position = position;
        ProcessedDate = processedDate;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
