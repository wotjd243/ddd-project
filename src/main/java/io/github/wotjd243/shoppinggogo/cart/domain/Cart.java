package io.github.wotjd243.shoppinggogo.cart.domain;

import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private Long id; //카트 키
    private Long userId; //유저 키
    private List<Product> products; //제품 목록
    private List<Long> checkedProductIds; //체크되어진 제품 ID 목록

    public Cart(Long id, Long userId, List<Product> products, List<Long> checkedProductIds) {
        this.id = id;
        this.userId = userId;
        this.products = products;
        this.checkedProductIds = new ArrayList<>(checkedProductIds);
    }

    /**
     * @todo 추후 구현
     * 중복된 상품들은 필터시킨다.
     * @param depricatedProduct 중복된 상품
     */
    public void filterByDepricatedProduct(Product depricatedProduct) {

    }

    /**
     * 체크되어진 제품 ID 목록을 조회한다.
     * @return 제품 ID 목록
     */
    public List<Long> getCheckedProductIds() {
        return checkedProductIds;
    }
}
