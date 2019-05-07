package io.github.wotjd243.shoppinggogo.order.application;

import io.github.wotjd243.shoppinggogo.cart.infra.CartRepository;
import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import io.github.wotjd243.shoppinggogo.user.domain.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {
    private UserRepository userRepository;
    private CartRepository cartRepository;

    public Order makeOrder(Long userId, String cartId) {
        Optional<User> maybeUser = userRepository.findById(userId);
        User user = maybeUser.get();

        List<Product> selectProducts = cartRepository.selectProductsToCart(userId);

        return new Order(userId,user.getAddress(), user.getPhoneNumber(),selectProducts.stream().map(product -> product.getId()).collect(Collectors.toList()));
    }
}
