package io.github.wotjd243.shoppinggogo.order.infra;

import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.order.domain.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;


@Repository
public class DummyOrderRepository implements OrderRepository {
    /**
     * orderId로 Repository 찾기
     * @param orderId
     * @return
     */
    @Override
    public Optional<Order> findbyId(long orderId) {
        return Optional.ofNullable(DummyOrderData.get(orderId));
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public ArrayList<Order> findByUserId(long userId) {
        ArrayList<Order> userOrders = new ArrayList<Order>();
        DummyOrderData.getOrderData(1L).forEach((key,value)->{
            if(value.getUser()==userId){
                userOrders.add(value);
            }
        });
        return userOrders;
    }
}
