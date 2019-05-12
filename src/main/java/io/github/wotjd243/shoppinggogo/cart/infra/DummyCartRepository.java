package io.github.wotjd243.shoppinggogo.cart.infra;

import io.github.wotjd243.shoppinggogo.cart.domain.Cart;
import org.springframework.stereotype.Repository;


@Repository
public class DummyCartRepository implements CartRepository {

    @Override
    public Cart findCartByUserId(Long userId) {
        return DummyCartData.getByUserId(userId);
    }
}
