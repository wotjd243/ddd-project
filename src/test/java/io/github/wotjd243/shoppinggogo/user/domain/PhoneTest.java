package io.github.wotjd243.shoppinggogo.user.domain;

import org.junit.Test;

import javax.xml.bind.ValidationException;

import static org.junit.Assert.*;

public class PhoneTest {


    @Test
    public void phoneValidate(){
        Phone phone = new Phone("01098890573");
    }

    /**
     * @// TODO: 14/05/2019 추후 해결
     */
    @Test
    public void 폰번호_입력확인(){
//        Phone phone = new Phone("0109883");
    }
}