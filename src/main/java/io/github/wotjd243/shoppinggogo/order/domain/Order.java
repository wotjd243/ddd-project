package io.github.wotjd243.shoppinggogo.order.domain;

import io.github.wotjd243.shoppinggogo.cart.domain.Cart;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.user.domain.Address;

import java.util.ArrayList;

//유저 장바구니 목록에 있는 것을 종합하여 주문한다.
public class Order {
    //주문 기능에 주소를 변경할 수 있다.

    private Address address;
    private Cart cartId;
    private ArrayList<Product> orderProducts;
    public Order(Address address, Cart cartid ) {
        this.address = address;
        this.cartId = cartid;
    }

    //유저의 장바구니 불러오기

    //담긴 상품에 대한 가격 측정
    public int calculateCart(){

        return 0;
    }

}
