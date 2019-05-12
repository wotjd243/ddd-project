package io.github.wotjd243.shoppinggogo.order.application;

import io.github.wotjd243.shoppinggogo.cart.infra.CartRepository;
import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.order.domain.OrderRepository;
import io.github.wotjd243.shoppinggogo.order.infra.DummyOrderData;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.user.application.UserService;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import io.github.wotjd243.shoppinggogo.user.domain.UserRepository;
import io.github.wotjd243.shoppinggogo.user.infra.DummyUserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private OrderService orderService;
    @InjectMocks
    private UserService userService;

    /**
     * TODO UserService line43 에서 NullPointException 해결하기
     *
     */
    @Test
    public void makeOrder() {

        given(orderRepository.findbyId(1L))
                .willReturn(Optional.of(DummyOrderData.get(1L)));

        ArrayList<Long> selectedProducts = new ArrayList<Long>();
        selectedProducts.add(1L);
        selectedProducts.add(2L);
        selectedProducts.add(3L);
        orderService.makeOrder(1L,selectedProducts);


    }

    /**
     * TODO
     */
    @Test
    public void sumOrderedProductsPrice() {
    }


    /**
     * TODO 상품 받아오는 클래스 구현
     */
    @Test
    public void getOrdedProducts() {
    }
}