package io.github.wotjd243.shoppinggogo.payment.application;

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
        this.sellerService = sellerService;
        this.paymentRepository = paymentRepository;
    }

    public void processOrder(String orderId, String userId, String sellerId, String paymentType ) {

        User user = this.userService.getUser(userId);
        Seller seller = this.sellerService.getSeller(sellerId).orElseThrow(IllegalArgumentException::new);
        Order order = new Order();

        PaymentMethod payment = null;
        if( paymentType.contains(PaymentType.CARD.getValue())) {
            payment = new CardPayment();
        } else if(paymentType.contains(PaymentType.CASH.getValue())) {
            payment = new CashPayment();
        }

//        orderService.getTotalAmount();
        payment.pay(userService, sellerService, Amount.valueOf(1111));

        this.paymentRepository.save(new Date(), UUID.randomUUID().toString(), orderId, Amount.valueOf(111), userId );

    }

}


