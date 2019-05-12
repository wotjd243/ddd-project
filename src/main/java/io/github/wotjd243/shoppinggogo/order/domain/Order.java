package io.github.wotjd243.shoppinggogo.order.domain;

import io.github.wotjd243.shoppinggogo.user.domain.Address;
import io.github.wotjd243.shoppinggogo.user.domain.Phone;
import lombok.Getter;

import java.util.List;

//유저 장바구니 목록에 있는 것을 종합하여 주문한다.
@Getter
public class Order {
    //주문 기능에 주소를 변경할 수 있다.
    private Long OrderId;
    private Long userId;
    private BuyerInfo buyerInfo;


    public Order(Long userId) {
        this.userId = userId;
    }

    public void setBuyerInfo( Address destination, Phone phone ,List<Long> orderProducts){
        this.buyerInfo = new BuyerInfo(destination, phone,orderProducts);
    }

}
