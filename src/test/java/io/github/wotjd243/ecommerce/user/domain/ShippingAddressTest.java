package io.github.wotjd243.ecommerce.user.domain;

import org.junit.Test;

public class ShippingAddressTest {

    private static final String TEST_ADDRESS_BLANK = "   ";
    private static final String TEST_ZIPCODE = "TEST_ZIPCODE";
    private static final String TEST_ADDRESS = "TEST_ADDRESS";

    @Test(expected = IllegalArgumentException.class)
    public void 주소가_값이_존재하는지_확인() {
        ShippingAddress shippingAddress = new ShippingAddress(TEST_ADDRESS_BLANK, TEST_ZIPCODE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 우편번호가_값이_존재하는지_확인() {
        ShippingAddress shippingAddress = new ShippingAddress(TEST_ADDRESS, null);
    }
}