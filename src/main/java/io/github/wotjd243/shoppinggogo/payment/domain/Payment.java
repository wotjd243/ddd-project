package io.github.wotjd243.shoppinggogo.payment.domain;

import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.user.domain.User;

import java.util.Date;

public class Payment {

    private final Long id; // 결제번호 { 20190315NP1385814158}
    private final Date paymentDate;  // 결제일자
    private PaymentDetailInfo paymentDetailInfo;

    public Payment(Date paymentDate, Long id, String orderId, Amount amountForPayment, String userId) {
        this.paymentDate = new Date(paymentDate.getTime());
        this.id = id;

    }
}

