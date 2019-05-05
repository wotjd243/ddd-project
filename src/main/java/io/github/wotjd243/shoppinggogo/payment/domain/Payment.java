package io.github.wotjd243.shoppinggogo.payment.domain;

import java.util.Date;

public interface Payment {

    // card시 iamport uid, 현금결제시 유저의 userId의 잔고서 빠져나가고 판매자의 userId에 돈 줌
    public void init(String uId);
    public void pay();


}

