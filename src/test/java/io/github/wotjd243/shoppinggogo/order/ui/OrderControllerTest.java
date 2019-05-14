package io.github.wotjd243.shoppinggogo.order.ui;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createOrder() throws Exception {
        String jsonParam = "{\n" +
                "\t\t\"userId\": 1,\n" +
                "\t\"selectedProducts\": [1,2,3]\t\n" +
                "}";

        this.mockMvc.perform(
                post("/order/create")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonParam))
                .andDo(print())
                .andExpect(status().isOk());

    }
}