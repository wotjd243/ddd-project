package io.github.wotjd243.ecommerce.Item.domain;

import io.github.wotjd243.ecommerce.buyer.domain.Buyer;
import io.github.wotjd243.ecommerce.buyer.domain.ItemOrder;
import io.github.wotjd243.ecommerce.buyer.domain.Order;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void 구매자_생성() {
       new Buyer(1, "baker street 221b", 0);
    }

}