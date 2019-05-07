package io.github.wotjd243.findbyhint.hunter.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HunterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void 총알구매성공() throws Exception {

        MockHttpServletRequestBuilder buyOneBullet = post("/buyOneBullet")
                .param("hunterId", "testId")
                .param("hunterPw", "testPw")
                .param("hunterName", "testName")
                .param("hunterPicturePath", "testPath")
                .param("hunterPictureName", "test.png")
                .param("hunterPoint", "147")
                .param("hunterBullet", "2");

        this.mockMvc.perform(buyOneBullet)
                .andDo(print());
    }

    // 올바른 Exception 처리 관련 질문해서 반영하기.
    @Test
    public void 총알구매실패_포인트부족() throws Exception {

        MockHttpServletRequestBuilder buyOneBullet = post("/buyOneBullet")
                .param("hunterId", "testId")
                .param("hunterPw", "testPw")
                .param("hunterName", "testName")
                .param("hunterPicturePath", "testPath")
                .param("hunterPictureName", "test.png")
                .param("hunterPoint", "22")
                .param("hunterBullet", "2");

        this.mockMvc.perform(buyOneBullet)
                .andDo(print());
        //.andExpect(status().is5xxServerError());
    }

    @Test
    public void 총알구매실패_최대개수초과() throws Exception {

        MockHttpServletRequestBuilder buyOneBullet = post("/buyOneBullet")
                .param("hunterId", "testId")
                .param("hunterPw", "testPw")
                .param("hunterName", "testName")
                .param("hunterPicturePath", "testPath")
                .param("hunterPictureName", "test.png")
                .param("hunterPoint", "147")
                .param("hunterBullet", "3");

        this.mockMvc.perform(buyOneBullet)
                .andDo(print());
        //.andExpect(status().is5xxServerError());
    }
}