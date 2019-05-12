package io.github.wotjd243.shoppinggogo.order.application;

import io.github.wotjd243.shoppinggogo.cart.application.CartService;
import io.github.wotjd243.shoppinggogo.cart.infra.CartRepository;
import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.order.domain.OrderRepository;
import io.github.wotjd243.shoppinggogo.product.application.ProductService;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.product.infra.ProductRepository;
import io.github.wotjd243.shoppinggogo.user.application.UserService;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import io.github.wotjd243.shoppinggogo.user.infra.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    /**
     *
     * @param userId
     * @return Order
     */
    public Order makeOrder(Long userId) {
        Optional<User> maybeUser = Optional.ofNullable(userService.getUser(userId).orElseThrow(IllegalArgumentException::new));
        User user = maybeUser.get();
        Order order = new Order(user.getId());
        order.setBuyerInfo(user.getAddress(),user.getPhoneNumber(), cartService.findProductsToCart(userId));
        return order;
    }

    /**
     * @param orderId
     * @return int totalPrice
     */
    public int sumOrderedProductsPrice(long orderId){
        Order order = getOrderById(orderId);

        int totalPrice = (int) order.getBuyerInfo().getOrderProducts().stream().mapToLong(
                (productId) ->
                productService.findProductById(productId).orElseThrow(IllegalArgumentException::new)
                        .findLowestPrice())
                        .sum();
        return totalPrice;
    }

    /**
     *
     * @param orderId
     * @return List<Product>
     */
    public List<Product> getOrdedProducts( long orderId) {
        Order order = getOrderById(orderId);
        //y = f(x)
        return order.getBuyerInfo().getOrderProducts().stream()
                .map(productId ->
                        productService.findProductById(productId)
                                .orElseThrow(IllegalArgumentException::new))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param orderId
     * @return Order
     */
    public Order getOrderById(long orderId){
        return orderRepository.findbyId(orderId)
                .orElseThrow(IllegalAccessError::new);
    }

}
