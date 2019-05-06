package io.github.wotjd243.ecommerce.item.domain;

import org.junit.Test;

public class DollarTest {

    @Test(expected = IllegalArgumentException.class)
    public void 음수체크() {
        new Dollar(-1.0);
    }

}