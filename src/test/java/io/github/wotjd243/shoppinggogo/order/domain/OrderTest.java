package io.github.wotjd243.shoppinggogo.order.domain;

import io.github.wotjd243.shoppinggogo.user.domain.Address;
import io.github.wotjd243.shoppinggogo.user.domain.Phone;
import org.junit.Test;

import java.util.ArrayList;


public class OrderTest {
    @Test
    public void 주문만들기(){
        ArrayList<Long> selectedProducts = new ArrayList<Long>();
        selectedProducts.add(1L);
        selectedProducts.add(2L);
        selectedProducts.add(3L);
        new Order(1L, new Buyer(new Address("Seoul"),new Phone("01000000000"),selectedProducts));
    }
}