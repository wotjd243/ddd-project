package io.github.book.collected.ui;

import io.github.book.collected.application.CollectedBookService;
import io.github.book.collected.application.dto.CollectedBookDto;
import io.github.book.collected.domain.BookLocation;
import io.github.book.collected.domain.CollectedBook;
import io.github.book.common.ControllerTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CollectedBookRestControllerTest extends ControllerTestBase {
    @MockBean
    private CollectedBookService collectedBookService;

    private CollectedBook collectedBook;
    private CollectedBookDto collectedBookDto;

    @BeforeEach
    public void setUp() {
        String isbn = UUID.randomUUID().toString();
        BookLocation bookLocation = BookLocation.builder().bookshelfLocation("우리집 안방 책장 1A").storeLocation("우리집 안방").build();
        collectedBook = CollectedBook.builder().bookIsbn(isbn).bookLocation(bookLocation).build();
        collectedBookDto = collectedBook.toDto();

    }

    @Test
    @DisplayName("콜렉티드 북 추가하기")
    public void saveCollectedBook() throws Exception {
        //given
        given(collectedBookService.saveCollectedBook(collectedBookDto)).willReturn(collectedBook);

        //when
        //then
        this.mockMvc.perform(post("/api/v1/collected-book")
                .content(objectMapper.writeValueAsString(collectedBookDto))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("대여 가능한 책들만 조회 테스트")
    public void collectedBookListTest() throws Exception {
        List<CollectedBook> collectedBooks = Arrays.asList(collectedBook);
        //given
        given(collectedBookService.getRentAvailableCollectedBook()).willReturn(collectedBooks);

        //when
        //then
        MvcResult mvcResult = this.mockMvc.perform(get("/api/v1/collected-book"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo(objectMapper.writeValueAsString(collectedBooks));
    }

}

