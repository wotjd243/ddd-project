package io.github.wotjd243.shoppinggogo.payment.infra;

import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.payment.domain.Amount;
import io.github.wotjd243.shoppinggogo.payment.domain.PaymentRepository;
import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.user.domain.User;

import java.util.Date;

public class PaymentRepositoryImpl implements PaymentRepository {

    @Override
    public boolean save(Date paymentDate, String id, String orderId, Amount amountForPayment, String userId) {
        return false;
    }
}
