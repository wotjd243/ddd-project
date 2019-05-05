package io.github.wotjd243.shoppinggogo.user.domain;

import org.junit.Test;

import javax.xml.bind.ValidationException;

import static org.junit.Assert.*;

public class PhoneTest {


    @Test
    public void phoneValidate(){
        Phone ph = new Phone("01098890573");
//        System.out.println("longType : "+1L);
    }


    @Test(expected = ValidationException.class)
    public void phoneValidate2(){
        Phone ph = new Phone("0109883");
    }
}