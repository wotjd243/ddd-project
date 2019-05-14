package io.github.wotjd243.shoppinggogo.payment.domain;

import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.user.domain.User;

import java.util.Date;
import java.util.Optional;

public interface PaymentRepository {
    public boolean save(Date paymentDate, Long id, Long orderId, Amount amountForPayment, Long userId);
    public Optional<Payment> findPaymentById(Long paymentId);

}
