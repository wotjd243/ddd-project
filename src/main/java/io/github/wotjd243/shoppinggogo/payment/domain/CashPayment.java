package io.github.wotjd243.shoppinggogo.payment.domain;

import java.util.Date;

public class CashPayment implements Payment {
    private Date paymentDate;  // 결제일자
    private String id; // 결제번호 { 20190315NP1385814158}
    private String orderId;    // 상품정보, 상품금액 ,판매자 ( 주문정보 )
    private Amount amountForPayment; // 결제할 돈
    private String userId; //유저
    //https://docs.iamport.kr/admin/test-mode
    @Override
    public void init(String userId) {
        this.userId = userId;
    }

    @Override
    public void pay() {
        // 테스트를 위해 임시로 지정, 실제 지불시에는 iamport연동
        // 1. user repo에서 유저 정보를 가져온다

        // 2. 유저정보에 있는 잔고에서 돈을 결제한다.

        // 3. seller에 잔고에 돈을 추가해준다.

    }
}
