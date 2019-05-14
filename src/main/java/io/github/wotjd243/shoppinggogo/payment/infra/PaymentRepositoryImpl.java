package io.github.wotjd243.shoppinggogo.payment.infra;

import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.payment.domain.Amount;
import io.github.wotjd243.shoppinggogo.payment.domain.Payment;
import io.github.wotjd243.shoppinggogo.payment.domain.PaymentRepository;
import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    @Override
    public boolean save(Date paymentDate, Long id, Long orderId, Amount amountForPayment, Long userId) {
        return false;
    }

    @Override
    public Optional<Payment> findPaymentById(Long paymentId) {


        return Optional.empty();
    }
}
