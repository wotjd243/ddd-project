package io.github.wotjd243.shoppinggogo.order.domain;

import io.github.wotjd243.shoppinggogo.product.domain.Product;

import java.util.ArrayList;

public class CalculateProductsService {

    private Order order;

    public CalculateProductsService(Order order){
        this.order=order;
    }

//    public int calcurateProductsPrice(Order order){
//        //같은 상품몰이면 배송비는 무료
//
//        int totalPrice = 0;
//        products.forEach((product)->{
//            totalPrice += product.findLowestPrice();
//        });
//
//        return totalPrice;
//    }
}
