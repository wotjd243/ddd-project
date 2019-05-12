package io.github.wotjd243.shoppinggogo.product.infra;

import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.product.domain.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummyProductRepository implements ProductRepository {

    @Override
    public Optional<Product> findbyId(long productId) {
        return Optional.ofNullable(DummayProductData.get(productId));
    }
}
