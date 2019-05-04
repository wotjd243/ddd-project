package io.github.wotjd243.ecommerce.product.domain;


import io.github.wotjd243.ecommerce.order.application.OrderService;
import io.github.wotjd243.ecommerce.order.domain.Order;
import io.github.wotjd243.ecommerce.order.domain.Paymethod;
import io.github.wotjd243.ecommerce.order.infra.ItemRepository;
import io.github.wotjd243.ecommerce.user.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    private final static String TEST_USER_ID = "TEST_USER";
    private static List<Item> items = new ArrayList<>();

    User user = new User(TEST_USER_ID);
    static {
        Item item1 = new Item("DDD Start", 25.00, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/140.jpg");
        items.add(item1);

        Item item2 = new Item("도메인 주도 설계 구현", 23.00, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/139.jpg");
        items.add(item2);
    }

    @Test
    public void 구매_생성() {
        ItemRepository itemRepository = new ItemRepository();
        OrderService orderService = new OrderService(itemRepository);

        new Order("1", user, Paymethod.CARD, items);
    }

    @Test void 결제_총합() {

    }

}
