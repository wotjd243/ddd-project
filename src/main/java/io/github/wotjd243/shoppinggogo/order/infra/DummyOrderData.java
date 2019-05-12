package io.github.wotjd243.shoppinggogo.order.infra;

import io.github.wotjd243.shoppinggogo.order.domain.Buyer;
import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.user.domain.Address;
import io.github.wotjd243.shoppinggogo.user.domain.Phone;

import java.util.*;

public class DummyOrderData {
    private static Map<Long, Order> orderData = new HashMap<Long,Order>();

    static {
        ArrayList<Long> products=new ArrayList<Long>();
        products.add(1L);
        products.add(2L);

        put(1L,1L, "Seoul","01011112222", products);
        put(2L,1L, "Seoul","01011112222", products);
        put(3L,1L, "Seoul","01011112222", products);

    }

    public static Order get(long orderId){
        return orderData.get(orderId);
    }
    //public Order(Long userId, Address destination, Phone phoneNumber ,ArrayList<Long> selectedProducts) {
    public static Order put( Long orderId, Long userId, String destination,
                             String phoneNumber, ArrayList<Long> selectedProducts
    ){
       return  orderData.put( orderId,
               new Order(1L,
                       new Buyer(
                               new Address(destination),
                               new Phone(phoneNumber),
                               new ArrayList<Long>(selectedProducts)
                       )
               )
       );
    }

}
