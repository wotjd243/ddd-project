package io.github.wotjd243.shoppinggogo.order.domain;

import io.github.wotjd243.shoppinggogo.user.domain.Address;

//유저 장바구니 목록에 있는 것을 종합하여 주문한다.
public class Order {
    //주문에 대한 aggregate 이므로 필드 생성 ㄴㄴ 기능만 만듬
    private Address address;
    private Cart cart;

    //유저의 장바구니 불러오기
    //담긴 상품에 대한 가격 측정


}
