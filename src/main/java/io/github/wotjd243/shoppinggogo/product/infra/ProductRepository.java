package io.github.wotjd243.shoppinggogo.product.infra;


import io.github.wotjd243.shoppinggogo.product.domain.Product;

public interface ProductRepository {

    Product findbyId(long productId);
}
