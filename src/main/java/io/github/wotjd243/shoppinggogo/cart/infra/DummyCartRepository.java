package io.github.wotjd243.shoppinggogo.cart.infra;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DummyCartRepository implements CartRepository {

    @Override
    public List<Long> selectProductsToCart(Long userId) {
        return DummyCartData.getByUserId(userId)
                .getCheckedProductIds();
    }
}
