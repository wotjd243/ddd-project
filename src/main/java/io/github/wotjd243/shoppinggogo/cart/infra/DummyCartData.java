package io.github.wotjd243.shoppinggogo.cart.infra;

import io.github.wotjd243.shoppinggogo.cart.domain.Cart;
import io.github.wotjd243.shoppinggogo.product.domain.Category;
import io.github.wotjd243.shoppinggogo.product.domain.PriceRecord;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.product.domain.ProductImage;

import java.util.*;

public class DummyCartData {

    private static final Map<Long, Cart> carts = new HashMap<>();

    static {
        put(1L, 1L, Arrays.asList(1L));
        put(2L, 2L, Arrays.asList(1L, 2L));
    }

    public static Cart getByUserId(final long userId) {
        return carts.get(userId);
    }

    public static Cart put(final Long cartId, final long userId, final List<Long> productIds){
        return carts.put(userId, new Cart(cartId, userId, productIds));
    }
}
