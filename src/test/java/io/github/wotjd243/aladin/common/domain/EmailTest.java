package io.github.wotjd243.aladin.common.domain;

import io.github.wotjd243.aladin.common.domain.Email;
import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.exception.WrongValueException;
import org.junit.Test;

public class EmailTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_이메일없음() {

        //given
        Email email = new Email("");
    }

    @Test(expected = WrongValueException.class)
    public void 비정상적인_이메일_ㄱㄴㄹㄴㅁㄹ() {

        //given
        Email email = new Email("ㄱㄴㄹㄴㅁㄹ");
    }

    @Test
    public void 정상적인_이메일_aaa_aaa_com() {

        //given
        Email email = new Email("aaa@aaa.com");
    }
}
