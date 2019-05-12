package io.github.wotjd243.shoppinggogo.order.ui;

import io.github.wotjd243.shoppinggogo.order.application.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     *
     * @param order userId, selectedProducts
     */
    @PostMapping("/order/create")
    public void createOrder(
            @RequestBody OrderDTO order
    ){
        orderService.makeOrder( order.getUserId(), order.getSelectedProducts());
    }



}
