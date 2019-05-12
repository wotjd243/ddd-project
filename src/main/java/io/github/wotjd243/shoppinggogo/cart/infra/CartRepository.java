package io.github.wotjd243.shoppinggogo.cart.infra;



import io.github.wotjd243.shoppinggogo.cart.domain.Cart;

import java.util.List;
import java.util.Optional;

public interface CartRepository {

    public Cart findCartByUserId(Long userId);

}
