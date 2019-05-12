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

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CollectedBookRestControllerTest extends ControllerTestBase {

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
        this.mockMvc.perform(post("/api/v1/collected-book")
                .content(objectMapper.writeValueAsString(collectedBookDto))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andDo(print())
                .andExpect(status().isCreated());
    }

}

