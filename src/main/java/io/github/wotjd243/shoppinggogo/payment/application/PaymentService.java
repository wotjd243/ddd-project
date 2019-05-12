package io.github.wotjd243.shoppinggogo.payment.application;

import io.github.wotjd243.shoppinggogo.order.application.OrderService;
import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.payment.domain.Amount;
import io.github.wotjd243.shoppinggogo.payment.domain.PaymentRepository;
import io.github.wotjd243.shoppinggogo.seller.application.SellerService;
import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.user.application.UserService;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import io.github.wotjd243.shoppinggogo.utils.PaymentType;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class PaymentService {

    private UserService userService;
    private SellerService sellerService;
    private OrderService orderService;
    private PaymentRepository paymentRepository;

    public PaymentService(UserService userService, SellerService sellerRepository, OrderService orderService, PaymentRepository paymentRepository) {
        this.userService = userService;
        this.sellerService = sellerService;
        this.orderService = orderService;
        this.paymentRepository = paymentRepository;
    }

    public void processOrder(Long orderId, Long userId, Long sellerId, String paymentType ) {

        User user = this.userService.getUser(userId).orElseThrow(IllegalArgumentException::new);
        Seller seller = this.sellerService.getSeller(sellerId).orElseThrow(IllegalArgumentException::new);

        PaymentMethod paymentMethod = null;

        if( paymentType.contains(PaymentType.CARD.getValue())) {
            paymentMethod = new CardPayment(userService, sellerService);
        } else if(paymentType.contains(PaymentType.CASH.getValue())) {
            paymentMethod = new CashPayment(userService, sellerService);
        }

        paymentMethod.pay(user, seller,  Amount.valueOf(this.orderService.sumOrderedProductsPrice(orderId)) );
        this.paymentRepository.save(new Date(), 1l, orderId, Amount.valueOf(this.orderService.sumOrderedProductsPrice(orderId)), userId );

    }

}


