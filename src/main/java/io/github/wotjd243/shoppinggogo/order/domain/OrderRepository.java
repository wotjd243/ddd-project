package io.github.wotjd243.shoppinggogo.order.domain;

import java.util.Optional;

public interface OrderRepository {

    public Optional<Order> findbyId(long orderid);
}
