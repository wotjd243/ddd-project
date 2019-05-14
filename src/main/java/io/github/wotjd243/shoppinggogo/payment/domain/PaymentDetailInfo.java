package io.github.wotjd243.shoppinggogo.payment.domain;

public class PaymentDetailInfo {

    private String orderId;    // 상품정보, 상품금액 ,판매자 ( 주문정보 )
    private Amount amountForPayment; // 결제할 돈
    private String userId; //유저

    public PaymentDetailInfo(String orderId, Amount amountForPayment, String userId) {
        this.orderId = orderId;
        this.amountForPayment = amountForPayment;
        this.userId = userId;
    }
}
