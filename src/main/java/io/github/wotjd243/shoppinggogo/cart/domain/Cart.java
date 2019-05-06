package io.github.wotjd243.shoppinggogo.cart.domain;

import io.github.wotjd243.shoppinggogo.product.domain.Product;

import java.util.List;

public class Cart {
    private Long id; //카트 키
    private String userId; //유저 키
    private List<Product> products; //제품 목록

    public Cart(Long id, String userId, List<Product> products) {
        this.id = id;
        this.userId = userId;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    /**
     * @todo 추후 구현
     * 중복된 상품들은 필터시킨다.
     * @param depricatedProduct 중복된 상품
     */
    public void filterByDepricatedProduct(Product depricatedProduct) {

    }

    /**
     * 카트에 담긴 제품 최저 가격의 총 합을 얻는다.
     * @param products 카트에 담긴 제품 목록
     */
    public int getProductLowestPriceSumByProducts(List<Product> products) {
        return products.stream().mapToInt(p -> p.findLowestPrice().getLowestPrice()).sum();
    }
}
