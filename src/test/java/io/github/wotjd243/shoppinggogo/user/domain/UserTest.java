package io.github.wotjd243.shoppinggogo.user.domain;

import jdk.Exported;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;
    @Test
    public void 유저(){
        User user = new User(1L,"kdy0573@daum.net", "Seoul","01011112222",1200000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이메일_확인(){
        User user = new User(1L,"kdy0573daum.net", "Seoul","01097050573",1200000);
    }
    @Test(expected = IllegalArgumentException.class)
    public void 번호확인(){
        User user = new User(1L,"kdy0573daum.net", "Seoul","0192",1200000);
    }

}