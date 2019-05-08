package io.github.wotjd243.shoppinggogo.cart.infra;

import io.github.wotjd243.shoppinggogo.product.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DummyCartRepository implements CartRepository {

    @Override
    public List<Long> selectProductsToCart(Long userId) {

        return DummyCartData.getByUserId(userId)
                .getProducts();
    }
}
