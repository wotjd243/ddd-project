package io.github.book.collected.application;

import io.github.book.book.domain.Author;
import io.github.book.book.domain.Book;
import io.github.book.book.infra.BookRepository;
import io.github.book.collected.domain.BookLocation;
import io.github.book.collected.domain.CollectedBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CollectedBook 서비스 테스트")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class CollectedBookServiceTest {
    @Autowired
    private CollectedBookService collectedBookService;
    @Autowired
    private BookRepository bookRepository;

    private Book book;

    @BeforeEach
    public void setUp() {
        String isbn = UUID.randomUUID().toString();
        Author author = Author.builder().authorName("조슈아").authorAge(2420).build();
        book = Book.builder().author(author)
                .title("이펙티브 자바")
                .isbn(isbn)
                .description("이펙티브 자바")
                .publishedDate(LocalDate.now()).build();
        bookRepository.save(book);
    }

    @Test
    @DisplayName("대여용 책 추가 테스트")
    void saveCollectedBookTest() {

        BookLocation bookLocation = BookLocation.builder().bookshelfLocation("우리집 안방 책장 1A").storeLocation("우리집 안방").build();
        CollectedBook collectedBook = CollectedBook.builder().bookIsbn(book.getIsbn()).bookLocation(bookLocation).build();
        collectedBookService.saveCollectedBook(collectedBook);

        assertThat(collectedBook.getCollectedBookId()).isNotNull();
    }


    @Test
    @DisplayName("대여 가능한 책들만 조회하는 테스트")
    void getRentAvailableCollectedBookTest() {

        BookLocation bookLocation = BookLocation.builder().bookshelfLocation("우리집 안방 책장 1A").storeLocation("우리집 안방").build();
        CollectedBook collectedBook = CollectedBook.builder().bookIsbn(book.getIsbn()).bookLocation(bookLocation).build();
        collectedBookService.saveCollectedBook(collectedBook);

        List<CollectedBook> collectedBookList = collectedBookService.getRentAvailableCollectedBook();
        assertThat(collectedBookList).isNotNull();
    }

    @Test
    @DisplayName("대여 후 대여 가능한 책 목록에 나타나지 않는지 테스트")
    void getRentAvailableCollectedBookZeroTest() {

        BookLocation bookLocation = BookLocation.builder().bookshelfLocation("우리집 안방 책장 1A").storeLocation("우리집 안방").build();
        CollectedBook collectedBook = CollectedBook.builder().bookIsbn(book.getIsbn()).bookLocation(bookLocation).build();
        collectedBookService.saveCollectedBook(collectedBook);
        collectedBook.rent();

        List<CollectedBook> collectedBookList = collectedBookService.getRentAvailableCollectedBook();
        assertThat(collectedBookList).isEmpty();
    }
}
