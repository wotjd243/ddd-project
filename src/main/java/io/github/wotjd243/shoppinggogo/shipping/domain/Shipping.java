package io.github.wotjd243.shoppinggogo.shipping.domain;

import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class Shipping implements Serializable {
    // 배송번호
    private Long id;

    private ShippingDetailInfo shippingDetail;
    // 송장정보 ( 송장정보, 택배사, 대표번호 )
    private Invoice Invoice;
    // 판매자 ( 개밥왕, 연락처 )
    private Seller seller;

    public Shipping(Long id, String shippingStatus, Long orderId, String position, Date processedDate,
                    Invoice invoice, Seller seller) {
        this.id = id;
        this.Invoice = invoice;
        this.seller = seller;
        this.shippingDetail = new ShippingDetailInfo(shippingStatus, orderId, position, processedDate);
    }

    public Long getId() {
        return id;
    }

    public ShippingDetailInfo getShippingDetail() {
        return shippingDetail;
    }
}
