package io.github.wotjd243.ecommerce.user.domain;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class ShippingAddressTest {

    @Test(expected = IllegalArgumentException.class)
    public void 주소가_값이_존재하는지_확인() {
        String TEST_USERID = "TEST_USERID";
        String TEST_ADDRESS = "   ";
        String TEST_ZIPCODE = "TEST_ZIPCODE";

        ShippingAddress shippingAddress = new ShippingAddress(TEST_USERID, TEST_ADDRESS, ZipCode.codeOf(TEST_ZIPCODE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 우편번호가_값이_존재하는지_확인() {
        String TEST_USERID = "TEST_USERID";
        String TEST_ADDRESS = "TEST_ADDRESS";
        String TEST_ZIPCODE = null;

        ShippingAddress shippingAddress = new ShippingAddress(TEST_USERID, TEST_ADDRESS, ZipCode.codeOf(TEST_ZIPCODE));
    }
}