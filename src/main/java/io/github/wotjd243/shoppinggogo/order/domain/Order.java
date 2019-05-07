package io.github.wotjd243.shoppinggogo.order.domain;

import io.github.wotjd243.shoppinggogo.cart.domain.Cart;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.user.domain.Address;
import io.github.wotjd243.shoppinggogo.user.domain.Phone;

import java.util.ArrayList;
import java.util.List;

//유저 장바구니 목록에 있는 것을 종합하여 주문한다.
public class Order {
    //주문 기능에 주소를 변경할 수 있다.
    private String OrderId;
    private Address destination;
    private Phone phone;
    private String userId;
    private List<Long> orderProducts;

    public Order(String userId, Address address, Phone phone, List<Long> products) {
        this.userId = userId;
        this.destination = address;
        this.orderProducts = products;
    }

    public void changeDestination (String newDestination){

    }

}
