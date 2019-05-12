package io.github.wotjd243.shoppinggogo.order.domain;

import io.github.wotjd243.shoppinggogo.user.domain.Address;
import io.github.wotjd243.shoppinggogo.user.domain.Phone;

import java.util.ArrayList;

//유저 장바구니 목록에 있는 것을 종합하여 주문한다.
public class Order {
    //주문 기능에 주소를 변경할 수 있다.
    private Long orderId;
    private Long userId;
    private Buyer buyer;

    /**
     *
     * @param userId
     * @param buyer
     */
    public Order(long userId, Buyer buyer) {
        this.userId = userId;
        this.buyer = buyer;
    }

    public Buyer getBuyer() {
        return this.buyer;
    }
    public long getUser(){return this.userId;}
}
