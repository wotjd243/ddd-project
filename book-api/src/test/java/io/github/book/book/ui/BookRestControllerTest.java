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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Book 컨트롤러 테스트")
class BookRestControllerTest extends ControllerTestBase {
    @MockBean
    private BookService bookService;
    private BookDto bookDto;
    private Book book;

    @BeforeEach
    public void setUp() {
        String isbn = UUID.randomUUID().toString();
        Author author = Author.builder().authorName("조슈아").authorAge(2420).build();
        book = Book.builder().isbn(isbn).title("이펙티브 자바").author(author).description("자바책").publishedDate(LocalDate.now()).build();
        bookDto = new BookDto(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getDescription(), book.getPublishedDate());
    }

    @DisplayName("책 생성에 관련된 api 테스트")
    @Test
    public void createBookApiTest() throws Exception {
        //given
        given(bookService.saveBook(bookDto)).willReturn(book);

        //when
        //then
        this.mockMvc.perform(post("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(bookDto)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("_links").hasJsonPath());
    }

    @DisplayName("책 목록 페이징을 통해 가져오는 api 테스트")
    @Test
    public void readBookListTest() throws Exception {
        //given
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page bookPage = new PageImpl(Arrays.asList(book), pageRequest, 1L);
        given(bookService.readBook(pageRequest)).willReturn(bookPage);

        //when
        //then
        this.mockMvc.perform(get("/api/v1/books")
                .param("page", "0")
                .param("size", "10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.bookList[0].isbn").hasJsonPath())
                .andExpect(jsonPath("page.number").value(0))
                .andExpect(jsonPath("page.size").value(10))
                .andExpect(jsonPath("_links").hasJsonPath());
    }
}
