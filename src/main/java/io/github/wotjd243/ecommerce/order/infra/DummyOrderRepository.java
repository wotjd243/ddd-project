package io.github.wotjd243.ecommerce.order.infra;

import io.github.wotjd243.ecommerce.order.domain.Buyer;
import io.github.wotjd243.ecommerce.order.domain.Order;
import io.github.wotjd243.ecommerce.order.domain.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DummyOrderRepository implements OrderRepository {
    private static List<Order> orders = new ArrayList<>();

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Order findById(String orderId) {
        return orders.stream().filter(v -> v.match(orderId)).findFirst().get();
    }

    @Override
    public List<Order> findByBuyer(Buyer buyer) {
        return orders.stream().filter(v -> v.isOwn(buyer)).collect(Collectors.toList());
    }
}
