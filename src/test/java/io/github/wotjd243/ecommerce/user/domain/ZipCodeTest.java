package io.github.wotjd243.ecommerce.user.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ZipCodeTest {

    @Test
    public void 우편번호가_유효한지_확인() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> ZipCode.codeOf("302-120")
        );
    }
}