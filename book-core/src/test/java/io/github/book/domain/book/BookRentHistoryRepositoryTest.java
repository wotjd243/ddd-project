package io.github.book.domain.book;


import io.github.book.domain.rent.infra.BookRentHistoryRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AllArgsConstructor
class BookRentHistoryRepositoryTest {
    private BookRentHistoryRepository bookRentHistoryRepository;

    @Test
    public void createBookRentHistoryTest() {

    }
}
