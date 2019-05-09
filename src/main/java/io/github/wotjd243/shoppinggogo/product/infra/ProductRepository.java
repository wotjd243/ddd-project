package io.github.wotjd243.shoppinggogo.product.infra;


import io.github.wotjd243.shoppinggogo.product.domain.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findbyId(long productId);
}
