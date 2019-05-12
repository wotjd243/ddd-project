package io.github.wotjd243.shoppinggogo.order.infra;

import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.order.domain.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class DummyOrderRepository implements OrderRepository {
    @Override
    public java.util.Optional<Order> findbyId(long orderId) {
        return Optional.ofNullable(DummyOrderData.get(orderId));
    }
}
