package io.github.wotjd243.shoppinggogo.order.ui;

import io.github.wotjd243.shoppinggogo.order.application.OrderService;
import io.github.wotjd243.shoppinggogo.order.domain.Order;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     *order 생성
     * @param order userId, selectedProducts
     */
    @PostMapping("/order/create")
    public void createOrder(
            @RequestBody OrderDTO order
    ){
        orderService.makeOrder( order.getUserId(), order.getSelectedProducts());
    }

    /**
     * 주문한 상품들의 정보를 response
     * @param orderId
     * @return List<Product>
     */
    @GetMapping("/order/id/")
    public List<Product> getOrderProducts( @RequestParam long orderId){
        return orderService.getOrdedProducts(orderId);
    }

    /**
     * 주문 상품의 총 가격
     * @param orderId
     * @return totalPrice
     */
    @GetMapping("/order/price/")
    public int sumProductsPrice( @RequestParam long orderId){

        return orderService.sumOrderedProductsPrice(orderId);
    }

    /**
     * 유저의 주문들의 정보들을 반환
     * @param userId
     * @return ArrayList<Order>
     */
    @GetMapping("/order/user/")
    public ArrayList<Order> getOrdersByUserId( @RequestParam long userId){
        return orderService.getOrderByUserId(userId);
    }


}
