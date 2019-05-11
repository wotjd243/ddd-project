package io.github.wotjd243.ecommerce.user.domain;

import org.junit.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ShippingAddressesTest {

    private static final ShippingAddresses shippingAddresses = new ShippingAddresses(new HashSet<>());

    @Test
    public void 중복된_주소가_저장되는지_확인() {
        shippingAddresses.add(new ShippingAddress("서울시 마포구 공덕동", "04208"));
        assertThatIllegalArgumentException().isThrownBy(
                () -> shippingAddresses.add(new ShippingAddress("서울시 마포구 공덕동", "04208")
                ));
    }
}