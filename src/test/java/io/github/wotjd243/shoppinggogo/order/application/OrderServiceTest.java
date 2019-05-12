package io.github.wotjd243.shoppinggogo.order.application;

import io.github.wotjd243.shoppinggogo.cart.infra.CartRepository;
import io.github.wotjd243.shoppinggogo.user.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void 주문_도메인_생성(){
        //repository를 두개 이상 쓸때는 어떻게 테스트를 하는지 궁금함
//        given(CartRepository.selectProductsToCart(any()))
//                .willReturn((Optional<User>) new Order(1L));
    }

}