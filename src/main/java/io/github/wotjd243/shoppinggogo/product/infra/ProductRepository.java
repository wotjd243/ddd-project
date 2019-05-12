package io.github.wotjd243.shoppinggogo.product.infra;


import io.github.wotjd243.shoppinggogo.product.domain.Product;

import java.util.Optional;

public interface ProductRepository {

    /**
     * 제품 ID 에 의해 제품 목록을 조회한다.
     * @param productId 제품 ID
     * @return 제품 정보
     */
    Optional<Product> findById(long productId);
}
