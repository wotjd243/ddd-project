package io.github.wotjd243.shoppinggogo.cart.domain;

import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Cart {
    private Long id; //카트 키
    private String userId; //유저 키
    private List<Product> products; //제품 목록
    private List<Long> checkedProductIds; //체크되어진 제품 ID 목록

    public Cart(Long id, String userId, List<Product> products, List<Long> checkedProductIds) {
        this.id = id;
        this.userId = userId;
        this.products = products;
        this.checkedProductIds = checkedProductIds;
    }

    /**
     * @todo 추후 구현
     * 중복된 상품들은 필터시킨다.
     * @param depricatedProduct 중복된 상품
     */
    public void filterByDepricatedProduct(Product depricatedProduct) {

    }


    /**
     * 카트에 담긴 제품 목록과 체크되어진 제품 목록을 매칭시킨다.
     * @param checkedProductIds 체크되어진 제품 ID 목록
     */
    public List<Product> matchByCheckedProductIds(List<Long> checkedProductIds) {
        return products.stream().filter(product ->
                        checkedProductIds.contains(product.getId()))
                .collect(Collectors.toList());
    }

    /**
     * 카트에 담긴 제품 최저 가격의 총 합을 얻는다.
     */
    public int getProductLowestPriceSumBySelectedProducts() {
        return matchByCheckedProductIds(checkedProductIds)
                .stream().mapToInt(p -> p.findLowestPrice().getLowestPrice()).sum();
    }
}
