package io.github.wotjd243.shoppinggogo.payment.application;

import io.github.wotjd243.shoppinggogo.payment.domain.Amount;
import io.github.wotjd243.shoppinggogo.seller.application.SellerService;
import io.github.wotjd243.shoppinggogo.user.application.UserService;

public class CardPayment implements PaymentMethod {

    @Override
    public void pay(UserService userService, SellerService sellerService, Amount amount) {

    }
}
