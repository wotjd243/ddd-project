package io.github.wotjd243.shoppinggogo.payment.ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.xml.internal.rngom.digested.DDataPattern;
import io.github.wotjd243.shoppinggogo.payment.application.PaymentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }
/*
    @GetMapping(path = "/payment")
    // payment시 order, user도메인의 기능을 호출해야한다
    public String getShipping(
            @RequestParam(value = "test1") String test1,
            @RequestParam(value = "test2") String test2,
//            @RequestBody,
//            @ModelAttribute
    ) {
        System.out.println(test1);
        System.out.println(test2);

        return "Good";

    }*/

}


