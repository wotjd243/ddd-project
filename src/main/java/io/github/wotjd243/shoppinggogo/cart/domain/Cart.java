package io.github.wotjd243.shoppinggogo.cart.domain;

import io.github.wotjd243.shoppinggogo.product.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Long id; //카트 키
    private Long userId; //유저 키
    private List<Long> productIds; //제품 목록

    public Cart(Long id, Long userId, List<Long> productIds) {
        this.id = id;
        this.userId = userId;
        this.productIds = new ArrayList<>(productIds);
    }

    public boolean removeProductFromCart(Long productId) {
        return productIds.remove(productId);
    }

    /**
     * @todo 추후 구현
     * 중복된 상품들은 필터시킨다.
     * @param depricatedProduct 중복된 상품
     */
    public void filterByDepricatedProduct(Product depricatedProduct) {

    }

    public List<Long> getProductIds() {
        return productIds;
    }
}
