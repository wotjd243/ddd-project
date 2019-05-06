package io.github.wotjd243.shoppinggogo.cart.domain;

import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.user.domain.User;

import java.util.List;

public class Cart {
    private String id;
    private User user;
    private List<Product> products;

    public Cart(String id, User user, List<Product> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }



    /**
     * 중복된 상품들은 필터시킨다.
     * @param depricatedProduct 중복된 상품
     */
    private void filterByDepricatedProduct(Product depricatedProduct) {

    }

    /**
     * 제품을 Cart 에 추가시킨다.
     * @param loginedUser 로그인 된 유저 정보
     * @param product Cart에 추가 될 제품
     */
    public void addProductToCart(User loginedUser, Product product) {

    }

    /**
     * 제품을 Cart 에서 제거시킨다.
     * @param product Cart 제거 될 제품
     */
    public void removeProductFromCart(User loginedUser, Product product) {

    }

    /**
     * 카트에 담긴 제품 가격의 총 합을 얻는다.
     * @param products 카트에 담긴 제품 목록
     */
    public void getProductPriceSumByProducts(User loginedUser, List<Product> products) {

    }
}
