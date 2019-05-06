package io.github.wotjd243.shoppinggogo.order.domain;

import io.github.wotjd243.shoppinggogo.product.domain.Product;

import java.util.ArrayList;

public class CalculateProductsService {

    private ArrayList<Product> products ;


    public CalculateProductsService(ArrayList<Product> products) {
        this.products = products;
    }

    public int calcurateProductsPrice(){
        //같은 상품몰이면 배송비는 무료

        int totalPrice = 0;
        products.forEach((product)->{
            totalPrice += product.findLowestPrice();
        });

        return totalPrice;
    }
}
