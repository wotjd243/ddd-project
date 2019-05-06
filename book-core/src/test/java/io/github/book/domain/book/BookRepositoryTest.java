package io.github.book.domain.book;

import io.github.book.domain.book.domain.Book;
import io.github.book.domain.book.infra.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Slf4j
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void createBookTest() {
        Book book = Book.builder().author("이학선").title("학선 일기")
                .isbn(UUID.randomUUID().toString()).description("학선님의 일기").publishedDate(LocalDate.now()).build();
        bookRepository.save(book);
        log.info("book info {}", book);
        assertThat(bookRepository.findById(book.getBookId())).isNotNull();
    }
}
