package io.github.wotjd243.shoppinggogo.product.infra;

import io.github.wotjd243.shoppinggogo.product.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummyProductRepository implements ProductRepository {

    @Override
    public Product findbyId(long productId) {
        return Optional.ofNullable(DummayProductData.get(productId));
    }
}
