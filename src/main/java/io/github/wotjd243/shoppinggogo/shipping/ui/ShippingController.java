package io.github.wotjd243.shoppinggogo.shipping.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.wotjd243.shoppinggogo.shipping.application.ShippingService;
import io.github.wotjd243.shoppinggogo.shipping.domain.Shipping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ShippingController {

    private ShippingService shippingService;
    private ObjectMapper mapper = new ObjectMapper();

    public ShippingController(final ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/shipping/{shippingNum}")
    public String getShipping(@PathVariable String shippingNum)
    {
        String result = "";
        try {
            System.out.println("shippingNum" + shippingNum);
            System.out.println(shippingService.getShippingInfo(shippingNum).get().getMall());
            System.out.println(shippingService.getShippingInfo(shippingNum).get().getShppingNum());
            System.out.println(shippingService.getShippingInfo(shippingNum).get().getId());
            System.out.println(shippingService.getShippingInfo(shippingNum).get().getOrderId());
            System.out.println(shippingService.getShippingInfo(shippingNum).get().getPosition());
            System.out.println(shippingService.getShippingInfo(shippingNum).get().getProcessedDate());

            result = mapper.writeValueAsString(shippingService.getShippingInfo(shippingNum).get());
            System.out.println("result" + result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
