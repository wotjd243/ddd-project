package io.github.wotjd243.ecommerce.order.domain;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);

    Order findById(String orderId);

    List<Order> findByBuyer(Buyer buyer);
}
