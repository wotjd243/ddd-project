package io.github.wotjd243.shoppinggogo.payment.application;

import io.github.wotjd243.shoppinggogo.payment.domain.Amount;
import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.user.domain.User;

public class CashPayment implements PaymentMethod {

    //https://docs.iamport.kr/admin/test-mode

    @Override
    public void pay(User user, Seller seller, Amount amount) {
        // 테스트를 위해 임시로 지정, 실제 지불시에는 iamport연동

        // 2. 유저정보에 있는 잔고에서 돈을 결제한다.

        // 3. seller에 잔고에 돈을 추가해준다.

    }
}
