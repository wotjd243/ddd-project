package io.github.wotjd243.ecommerce.order.domain;

import io.github.wotjd243.ecommerce.item.application.ItemService;
import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.infra.DummyItemRepository;
import io.github.wotjd243.ecommerce.user.application.UserService;
import io.github.wotjd243.ecommerce.user.infra.DummyUserRepository;
import io.github.wotjd243.ecommerce.utils.BasketUtils;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingBasketTest {
    UserService userService = new UserService(new DummyUserRepository());
    ItemService itemService = new ItemService(new DummyItemRepository(), userService);
    private List<ItemResponseDto> items = itemService.searchAll();

    @Test
    public void 장바구니에_담은_상품의_총_금액_계산() {
        ShoppingBasket basket = new ShoppingBasket(BasketUtils.consider(items));

        assertThat(basket.sumPrice()).isEqualTo(251.46);
    }
}