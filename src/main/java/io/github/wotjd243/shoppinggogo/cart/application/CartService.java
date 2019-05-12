package io.github.wotjd243.shoppinggogo.cart.application;


import io.github.wotjd243.shoppinggogo.cart.domain.Cart;
import io.github.wotjd243.shoppinggogo.cart.infra.CartRepository;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.product.application.ProductService;
import io.github.wotjd243.shoppinggogo.user.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartRepository cartRepository;

    /**
     * @todo 추후, 구현
     * 제품을 Cart 에 추가시킨다.
     *
     * @param userId 유저 ID
     * @param product Cart에 추가 될 제품
     */
    public void addProductToCart(Long userId, Product product) {
    }

    /**
     * @todo 추후, 구현
     * 제품을 Cart 에서 제거시킨다.
     *
     * @param userId 유저 ID
     * @param product Cart 제거 될 제품
     */
    public void removeProductFromCart(Long userId, Product product) {

    }

    /**
     * Cart 에 담긴 제품 목록을 찾는다.
     *
     * @param userId 유저 ID
     * @return Cart 에 담긴 제품 목록
     */
    public List<Long> findProductsToCart(Long userId) {

        Cart cart = cartRepository.findCartByUserId(userId);

        return cart.getProductIds();
    }

}
