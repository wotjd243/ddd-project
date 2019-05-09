package io.github.wotjd243.aladin.reservation.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.wotjd243.aladin.exception.MaxOverReservationException;
import io.github.wotjd243.aladin.reservation.application.ReservationService;
import io.github.wotjd243.aladin.response.ApiResponse;
import io.github.wotjd243.aladin.response.ApiResponseCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static io.github.wotjd243.aladin.reservation.application.ReservationService.LIMIT_RESERVATION_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.willThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {ReservationController.class})
public class ReservationControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationService;

    @Test
    public void 실패_생성요청_파라미터없음() throws Exception {

        //given
        //when
        MvcResult mvcResult = this.mockMvc.perform(post("/reservation")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        //then
        ApiResponse apiResponse = getApiResponse(mvcResult);

        assertThat(apiResponse.getCode()).isEqualTo(ApiResponseCode.BAD_PARAMETER);
        assertThat(apiResponse.getMessage()).isEqualTo("파라미터가 존재하지 않습니다.");
    }

    @Test
    public void 실패_생성요청_파라미터비어있음() throws Exception {

        //given
        String requestBody = "{\"bookId\":\"\"}";

        //when
        MvcResult mvcResult = this.mockMvc.perform(post("/reservation")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        //then
        ApiResponse apiResponse = getApiResponse(mvcResult);

        assertThat(apiResponse.getCode()).isEqualTo(ApiResponseCode.BAD_PARAMETER);
        assertThat(apiResponse.getMessage()).isEqualTo("요청 파라미터가 잘못되었습니다.");
    }

    @Test
    public void 실패_생성요청_파라미터타입이_다름() throws Exception {

        //given
        String requestBody = "{\"bookId\":\"ㄱㄴ\"}";

        //when
        MvcResult mvcResult = this.mockMvc.perform(post("/reservation")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn();

        //then
        ApiResponse apiResponse = getApiResponse(mvcResult);

        assertThat(apiResponse.getCode()).isEqualTo(ApiResponseCode.BAD_PARAMETER);
        assertThat(apiResponse.getMessage()).isEqualTo("[bookId] 타입은 Long 이여야합니다. 실제값 : ㄱㄴ");
    }

    @Test
    public void 실패_15권_이상_찜_생성요청() throws Exception {

        //given
        String requestBody = "{\"bookId\":1}";

        willThrow(new MaxOverReservationException(String.format("최대 %s 권을 찜할 수 있습니다.", LIMIT_RESERVATION_COUNT)))
                .given(reservationService)
                .add(anyLong(), anyLong());

        //when
        MvcResult mvcResult = this.mockMvc.perform(post("/reservation")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(status().isBadRequest())
                .andDo(print())
                .andReturn();

        //then
        ApiResponse apiResponse = getApiResponse(mvcResult);

        assertThat(apiResponse.getCode()).isEqualTo(ApiResponseCode.BAD_PARAMETER);
        assertThat(apiResponse.getMessage()).isEqualTo("최대 15 권을 찜할 수 있습니다.");
    }

    @Test
    public void 성공_생성요청() throws Exception {

        //given
        String requestBody = "{\"bookId\":1}";

        //when
        MvcResult mvcResult = this.mockMvc.perform(post("/reservation")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        //then
        ApiResponse apiResponse = getApiResponse(mvcResult);

        assertThat(apiResponse.getCode()).isEqualTo(ApiResponseCode.OK);
        assertThat(apiResponse.getMessage()).isEqualTo("요청이 성공하였습니다.");
    }

    private ApiResponse getApiResponse(MvcResult mvcResult) throws java.io.IOException {

        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(mockHttpServletResponse.getContentAsString(), ApiResponse.class);
    }

}
