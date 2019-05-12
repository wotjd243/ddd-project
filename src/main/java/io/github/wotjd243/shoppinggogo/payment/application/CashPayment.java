package io.github.wotjd243.shoppinggogo.payment.application;

import io.github.wotjd243.shoppinggogo.payment.domain.Amount;
import io.github.wotjd243.shoppinggogo.seller.application.SellerService;
import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.user.application.UserService;
import io.github.wotjd243.shoppinggogo.user.domain.User;

public class CashPayment implements PaymentMethod {

    private UserService userService;
    private SellerService sellerService;

    public CashPayment(UserService userService, SellerService sellerService) {
        this.userService = userService;
        this.sellerService = sellerService;
    }

    @Override
    public void pay(User user, Seller seller, Amount amount) {
        userService.lossUserPoint(user.getId(), amount.getAmount());
        sellerService.addPointToSeller(seller.getId(), amount.getAmount());
    }
}
