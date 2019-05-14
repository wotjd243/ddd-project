package io.github.wotjd243.shoppinggogo.payment.application;

import io.github.wotjd243.shoppinggogo.payment.domain.Amount;
import io.github.wotjd243.shoppinggogo.seller.application.SellerService;
import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.user.application.UserService;
import io.github.wotjd243.shoppinggogo.user.domain.User;

public interface PaymentMethod {
    public void pay(User user, Seller seller, Amount amount);
}
