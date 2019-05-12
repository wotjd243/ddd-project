package io.github.wotjd243.shoppinggogo.user.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Condition.matched;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
public class EmailTest {

    @Test
    public void EmailTest() {
        new Email("rkskek@naver.com");
    }
}