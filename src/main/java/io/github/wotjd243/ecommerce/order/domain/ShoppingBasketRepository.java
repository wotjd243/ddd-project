package io.github.wotjd243.ecommerce.order.domain;

import java.util.List;

public interface ShoppingBasketRepository {
    ShoppingBasket save(ShoppingBasket shoppingBasket);

    ShoppingBasket findById(String basketId);

    List<ShoppingBasket> findByBuyer(Buyer buyer);
}
