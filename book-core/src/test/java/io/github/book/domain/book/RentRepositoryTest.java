package io.github.book.domain.book;


import io.github.book.domain.rent.infra.RentRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AllArgsConstructor
class RentRepositoryTest {
    private RentRepository rentRepository;

    @Test
    public void createRentTest() {

    }
}
