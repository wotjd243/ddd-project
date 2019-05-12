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
     * @param param userid, ArrayList<Long>
     */
    @PostMapping("/order/create")
    public void createOrder(
            @RequestBody OrderParam param
    ) {

        System.out.println(param.getUserId());
        System.out.println(param.getSelectedProducts().size());
        orderService.makeOrder(param.getUserId(), param.getSelectedProducts());
    }

}
