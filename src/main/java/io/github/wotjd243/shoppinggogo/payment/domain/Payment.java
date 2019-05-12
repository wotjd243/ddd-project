package io.github.wotjd243.shoppinggogo.payment.domain;

import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.user.domain.User;

import java.util.Date;

public class Payment {

    private Date paymentDate;  // 결제일자
    private Long id; // 결제번호 { 20190315NP1385814158}
    private String orderId;    // 상품정보, 상품금액 ,판매자 ( 주문정보 )
    private Amount amountForPayment; // 결제할 돈
    private String userId; //유저

    public Payment(Date paymentDate, Long id, String orderId, Amount amountForPayment, String userId) {
        this.paymentDate = paymentDate;
        this.id = id;
        this.orderId = orderId;
        this.amountForPayment = amountForPayment;
        this.userId = userId;
    }
}

