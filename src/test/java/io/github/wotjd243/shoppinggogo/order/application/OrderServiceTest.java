package io.github.wotjd243.shoppinggogo.order.application;

import io.github.wotjd243.shoppinggogo.cart.infra.CartRepository;
import io.github.wotjd243.shoppinggogo.user.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;


    @Test
    public void makeOrder() {
        Order order = orderService.makeOrder(1L, Arrays.asList(1L,2L,3L));
        List<Product> products = orderService.getOrdedProducts(1L);
        List<Long> productList = new ArrayList<Long>();
        productList.add(1L);
        productList.add(2L);
        productList.add(3L);


        assertThat(order.getBuyerInfo().getOrderProducts()
        assertThat(order.getBuyerInfo().getOrderProducts(), productList);

    }

    @Test
    public void sumOrderedProductsPrice() {
    }

    @Test
    public void getOrdedProducts() {
    }
}