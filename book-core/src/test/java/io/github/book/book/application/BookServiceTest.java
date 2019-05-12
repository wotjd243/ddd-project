package io.github.book.book.application;


import io.github.book.book.application.dto.BookDto;
import io.github.book.book.domain.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CollectedBook 서비스 테스트")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("책 정보 추가 테스트")
    void saveCollectedBookTest() {
        String isbn = UUID.randomUUID().toString();
        Author author = Author.builder().authorName("조슈아").authorAge(2420).build();
        BookDto bookDto = new BookDto(isbn, "이펙티브 자바", author, "대충 쓴 책", LocalDate.now());

        bookService.saveBook(bookDto);

        assertThat(bookService.findByIsbn(bookDto.getIsbn())).isNotNull();
    }
}
