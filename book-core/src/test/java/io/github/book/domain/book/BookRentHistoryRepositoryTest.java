package io.github.book.domain.book;


import lombok.AllArgsConstructor;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AllArgsConstructor
class BookRentHistoryRepositoryTest {
    private BookRentHistoryRepository bookRentHistoryRepository;

    @Test
    public void createBookRentHistoryTest() {

    }
}
