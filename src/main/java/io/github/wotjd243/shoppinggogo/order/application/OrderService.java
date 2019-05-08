package io.github.wotjd243.shoppinggogo.order.application;

import io.github.wotjd243.shoppinggogo.cart.infra.CartRepository;
import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.product.infra.ProductRepository;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import io.github.wotjd243.shoppinggogo.user.infra.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private UserRepository userRepository;
    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public Order makeOrder(Long userId, String cartId) {
        Optional<User> maybeUser = userRepository.findById(userId);
        User user = maybeUser.get();
        Order order = new Order(user.getId());
        order.enterOrderProducts( cartRepository.selectProductsToCart(userId));
        order.enterAddress( user.getAddress());
        order.enterPhone( user.getPhoneNumber());
        return order;
    }

    public int calculateOrderProductsPrice(List<Long> products){
        int totalPrice = 0;
        products.forEach((productId)->{
           totalPrice+=productRepository.findbyId(productId).getLowPrice();
        });

        return totalPrice;
    }
    public List<Product> getProductList ( long userid){
        

    }

}
