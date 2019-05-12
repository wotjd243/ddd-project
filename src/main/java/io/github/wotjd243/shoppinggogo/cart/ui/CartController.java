package io.github.wotjd243.shoppinggogo.cart.ui;


import io.github.wotjd243.shoppinggogo.cart.application.CartService;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart/product/list")
    public List<Product> findProducts(@RequestParam Long userId) {
        return cartService.findProductsFromCart(userId);
    }
}
