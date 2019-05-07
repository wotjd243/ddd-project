package io.github.wotjd243.aladin.common.domain;

import io.github.wotjd243.aladin.common.domain.PhoneNumber;
import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.exception.WrongValueException;
import org.junit.Test;

public class PhoneNumberTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_폰넘버없음() {

        //given
        PhoneNumber phoneNumber = new PhoneNumber("");
    }

    @Test(expected = WrongValueException.class)
    public void 비정상적인_폰넘버_ㄱㄴㄹㄴㅁㄹ() {

        //given
        PhoneNumber phoneNumber = new PhoneNumber("ㄱㄴㄹㄴㅁㄹ");
    }

    @Test(expected = WrongValueException.class)
    public void 비정상적인_폰넘버_01071611234() {

        //given
        PhoneNumber phoneNumber = new PhoneNumber("01071611234");
    }

    @Test
    public void 정상적인_폰넘버_010_7161_1234() {

        //given
        PhoneNumber phoneNumber = new PhoneNumber("010-7161-1234");
    }
}
