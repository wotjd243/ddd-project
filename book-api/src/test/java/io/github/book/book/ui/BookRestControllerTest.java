package io.github.book.book.ui;

import io.github.book.book.application.BookService;
import io.github.book.book.application.dto.BookDto;
import io.github.book.book.domain.Author;
import io.github.book.book.domain.Book;
import io.github.book.common.ControllerTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Book 컨트롤러 테스트")
class BookRestControllerTest extends ControllerTestBase {
    @MockBean
    private BookService bookService;
    private BookDto bookDto;

    @BeforeEach
    public void setUp() {
        String isbn = UUID.randomUUID().toString();
        Author author = Author.builder().authorName("조슈아").authorAge(2420).build();
        Book book = Book.builder().isbn(isbn).title("이펙티브 자바").author(author).description("자바책").publishedDate(LocalDate.now()).build();
        bookDto = new BookDto(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getDescription(), book.getPublishedDate());
        given(bookService.saveBook(bookDto)).willReturn(book);
    }

    @DisplayName("책 생성에 관련된 api 테스트")
    @Test
    public void createBookApiTest() throws Exception {
        this.mockMvc.perform(post("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(bookDto)))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
