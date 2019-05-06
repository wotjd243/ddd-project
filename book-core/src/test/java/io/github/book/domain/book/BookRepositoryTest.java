package io.github.book.domain.book;

import io.github.book.domain.book.domain.Author;
import io.github.book.domain.book.domain.Book;
import io.github.book.domain.book.infra.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@DisplayName("BookRepository 테스트")
@Slf4j
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("Book 생성 테스트")
    public void createBookTest() {
        Author author = Author.builder().authorName("조슈아").authorAge(2420).build();
        Book book = Book.builder().author(author)
                .title("이펙티브 자바")
                .isbn(UUID.randomUUID().toString())
                .description("이펙티브 자바")
                .publishedDate(LocalDate.now()).build();
        bookRepository.save(book);
        log.info("book info {}", book);
        assertThat(book.getIsbn()).isNotNull();
    }

    @Test
    @DisplayName("Book 조회 테스트")
    public void searchBookTest() {
        String isbn = UUID.randomUUID().toString();
        Author author = Author.builder().authorName("조슈아").authorAge(2420).build();
        Book book = Book.builder().author(author)
                .title("이펙티브 자바")
                .isbn(isbn)
                .description("이펙티브 자바")
                .publishedDate(LocalDate.now()).build();
        bookRepository.save(book);
        log.info("book info {}", book);
        Book findBook = bookRepository.findByIsbn(isbn).get();
        assertThat(findBook.getIsbn()).isEqualTo(isbn);
    }
}
