package io.github.wotjd243.shoppinggogo.order.application;

import io.github.wotjd243.shoppinggogo.cart.application.CartService;
import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.order.domain.OrderRepository;
import io.github.wotjd243.shoppinggogo.product.application.ProductService;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.user.application.UserService;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public OrderService( OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    /**
     *
     * @param userId
     * @return Order
     */
    public Order makeOrder(Long userId) {
        User user = userService.getUser(userId).orElseThrow(IllegalArgumentException::new);
        Order order = new Order(user.getId());
        order.setBuyerInfo(user.getAddress(),user.getPhoneNumber(), cartService.findProductIdsFromCart(userId));
        return order;
    }

    /**
     * @param orderId
     * @return 주문 총 합계
     */
    public int sumOrderedProductsPrice(long orderId){
        return (int) getOrderById(orderId).getBuyerInfo().getOrderProducts().stream()
                .mapToLong((productId) ->
                productService.findProductById(productId).orElseThrow(IllegalArgumentException::new)
                        .findLowestPrice())
                        .sum();
    }

    /**
     *
     * @param orderId
     * @return List<Product>
     */
    public List<Product> getOrdedProducts( long orderId) {

        return getOrderById(orderId).getBuyerInfo().getOrderProducts().stream()
                .map(productId ->
                        productService.findProductById(productId)
                                .orElseThrow(IllegalArgumentException::new))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param orderId
     * @return Order 정보
     */
    public Order getOrderById(long orderId){
        return orderRepository.findbyId(orderId)
                .orElseThrow(IllegalArgumentException::new);
    }

}
