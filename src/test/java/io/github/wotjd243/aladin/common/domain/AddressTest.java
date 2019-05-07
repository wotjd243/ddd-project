package io.github.wotjd243.aladin.common.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import org.junit.Test;

public class AddressTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_주소없음() {

        //given
        Address address = new Address("");
    }

    @Test
    public void 정상적인_주소_용인시() {

        //given
        Address address = new Address("용인시");
    }
}
