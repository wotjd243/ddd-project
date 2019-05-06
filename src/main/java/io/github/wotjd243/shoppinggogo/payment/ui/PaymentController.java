package io.github.wotjd243.shoppinggogo.payment.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.wotjd243.shoppinggogo.payment.application.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/payment", consumes = "application/json", produces = "application/json")
    // payment시 order, user도메인의 기능을 호출해야한다
    public String getShipping(@PathVariable String orderIdAnduserId )
    {


        return  null;

    }

}


