package io.github.wotjd243.shoppinggogo.order.infra;

import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.user.domain.Address;
import io.github.wotjd243.shoppinggogo.user.domain.Phone;

import java.util.*;

public class DummyOrderData {
    private static Map<Long, Order> orderData = new HashMap<Long,Order>();

    static {
        put(1L,1L);
        put(2L,2L);
        put(3L,1L);
    }

    public static Order get(long orderId){
        return orderData.get(orderId);
    }
    public static Order put(Long orderId,Long userId){
       return  orderData.put( orderId,new Order(userId));
    }

}
