package io.github.wotjd243.ecommerce.order.application;

import io.github.wotjd243.ecommerce.order.application.dto.OrderResponseDto;
import io.github.wotjd243.ecommerce.order.domain.Buyer;
import io.github.wotjd243.ecommerce.order.domain.Order;
import io.github.wotjd243.ecommerce.order.domain.Order.PayMethod;
import io.github.wotjd243.ecommerce.order.domain.OrderRepository;
import io.github.wotjd243.ecommerce.order.domain.ShoppingBasket;
import io.github.wotjd243.ecommerce.user.application.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;

    public OrderService(OrderRepository OrderRepository, UserService userService) {
        this.orderRepository = OrderRepository;
        this.userService = userService;
    }

    //TODO: 장바구니에 담기 기능이 구현되어야 한다.

    public OrderResponseDto order(Buyer buyer, PayMethod method, ShoppingBasket basket) {
        userService.checkValid(buyer.getUserId());

        //TODO: 주문이 완료되기 전에 결재가 진행되어야 한다.
        Order order = new Order(buyer, method, basket);
        return orderRepository.save(order).toDto();
    }

    public List<OrderResponseDto> findOrders(Buyer buyer) {
        List<Order> orders = orderRepository.findByBuyer(buyer);
        return orders.stream().map(v -> v.toDto()).collect(Collectors.toList());
    }

    public OrderResponseDto findOrder(String orderId) {
        return orderRepository.findById(orderId).toDto();
    }
}
