package io.github.wotjd243.shoppinggogo.shipping.domain;

import io.github.wotjd243.shoppinggogo.seller.domain.Seller;

import java.io.Serializable;
import java.util.Date;

public class Shipping implements Serializable {
    // 배송번호
    private String id;
    private String mall;
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
    private String destination;


    public Shipping( String id, String mall, String shippingStatus, String orderId, String position, Date processedDate,
                    Invoice invoice, Seller seller, String destination) {
        this.id = id;
        this.mall = mall;
        this.shippingStatus = shippingStatus;
        this.orderId = orderId;
        this.position = position;
        this.ProcessedDate = processedDate;
        this.Invoice = invoice;
        this.seller = seller;
        this.destination = destination;
    }

    public String getMall() {
        return mall;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMall(String mall) {
        this.mall = mall;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getProcessedDate() {
        return ProcessedDate;
    }

    public void setProcessedDate(Date processedDate) {
        ProcessedDate = processedDate;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public Invoice getInvoice() {
        return Invoice;
    }

    public void setInvoice(Invoice invoice) {
        Invoice = invoice;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
