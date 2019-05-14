package io.github.wotjd243.shoppinggogo.user.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void isUserLogIn() throws Exception {
        this.mockMvc.perform(get("/user/1/loggedin"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * @// TODO: 14/05/2019 추후 해결
     * @throws Exception
     */
    @Test
    public void getUserInfo() throws Exception {
//        this.mockMvc.perform(get("/user/1"))
//                .andDo(print())
//                .andExpect(status().isOk());
    }

}