package io.github.wotjd243.ecommerce.order.application;

import io.github.wotjd243.ecommerce.item.application.ItemService;
import io.github.wotjd243.ecommerce.item.infra.DummyItemRepository;
import io.github.wotjd243.ecommerce.order.application.dto.OrderResponseDto;
import io.github.wotjd243.ecommerce.order.domain.Buyer;
import io.github.wotjd243.ecommerce.order.domain.Order.PayMethod;
import io.github.wotjd243.ecommerce.order.domain.ShoppingBasket;
import io.github.wotjd243.ecommerce.order.infra.DummyOrderRepository;
import io.github.wotjd243.ecommerce.user.application.UserService;
import io.github.wotjd243.ecommerce.user.infra.DummyUserRepository;
import io.github.wotjd243.ecommerce.utils.BasketUtils;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    private final static String TEST_USER_ID = "TEST_USER";
    private final static String TEST_USER_ADDRESS = "서울시";

    UserService userService = new UserService(new DummyUserRepository());
    OrderService orderService = new OrderService(new DummyOrderRepository(), userService);
    ItemService itemService = new ItemService(new DummyItemRepository(), userService);

    @Test
    public void 한개_주문() {
        Buyer buyer = new Buyer(TEST_USER_ID, TEST_USER_ADDRESS);
        PayMethod method = PayMethod.CARD;
        ShoppingBasket basket = new ShoppingBasket(BasketUtils.consider(itemService.searchItems("DDD")));

        OrderResponseDto result = orderService.order(buyer, method, basket);
        assertThat(basket.size()).isEqualTo(1);

        OrderResponseDto order = orderService.findOrder(result.getOrderId());
        assertThat(order).isEqualTo(result);
    }

    @Test
    public void 여러개_주문() {
        Buyer buyer = new Buyer(TEST_USER_ID, TEST_USER_ADDRESS);
        PayMethod method = PayMethod.CARD;
        ShoppingBasket basket = new ShoppingBasket(BasketUtils.consider(itemService.searchAll()));

        OrderResponseDto result = orderService.order(buyer, method, basket);
        List<OrderResponseDto> orders = orderService.findOrders(buyer);

        assertThat(basket.size()).isEqualTo(4);
        assertThat(orders).contains(result);
    }
}