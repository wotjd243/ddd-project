package io.github.wotjd243.shoppinggogo.order.application;

import io.github.wotjd243.shoppinggogo.cart.infra.CartRepository;
import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.order.domain.OrderRepository;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.product.infra.ProductRepository;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import io.github.wotjd243.shoppinggogo.user.infra.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private UserRepository userRepository;
    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    public Order makeOrder(Long userId, String cartId) {
        Optional<User> maybeUser = Optional.ofNullable(userRepository.findById(userId).orElseThrow(IllegalArgumentException::new));
        User user = maybeUser.get();
        Order order = new Order(user.getId());
        order.enterOrderProducts( cartRepository.selectProductsToCart(userId));
        order.enterAddress( user.getAddress());
        order.enterPhone( user.getPhoneNumber());
        return order;
    }

    /**
     * @param orderId
     * @return
     */
    public int sumOrderedProductsPrice(long orderId){
        Order order = getOrderById(orderId);
        int totalPrice = (int) order.getOrderProducts().stream().mapToLong(
                (productId) ->
                productRepository.findbyId(productId).orElseThrow(IllegalArgumentException::new)
                        .findLowestPrice())
                        .sum();
        return totalPrice;
    }

    public List<Product> getOrdedProducts( long orderId){
        Order order = getOrderById(orderId);
        //y = f(x)
        return order.getOrderProducts().stream()
                .map(productId ->
                        productRepository.findbyId(productId)
                                .orElseThrow(IllegalArgumentException::new))
                .collect(Collectors.toList());
    }

    public Order getOrderById(long orderId){
        return orderRepository.findbyId(orderId)
                .orElseThrow(IllegalAccessError::new);
    }

}
