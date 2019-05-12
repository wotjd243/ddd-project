package io.github.wotjd243.shoppinggogo.shipping.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.wotjd243.shoppinggogo.shipping.application.ShippingService;
import io.github.wotjd243.shoppinggogo.shipping.domain.Shipping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // 배송 확인
    @GetMapping("/shipping/{shippingNum}")
    public ResponseEntity<Shipping> getShipping(@PathVariable String shippingNum)
    {
        if( shippingService.getShippingInfo(shippingNum).isPresent() ) {
            return new ResponseEntity(shippingService.getShippingInfo(shippingNum).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
