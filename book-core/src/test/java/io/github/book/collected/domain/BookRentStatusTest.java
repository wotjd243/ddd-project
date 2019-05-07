package io.github.book.collected.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BookRentStatus enum 테스트")
class BookRentStatusTest {

    @Test
    @DisplayName("렌트가 가능한 상태 여부 테스트")
    void testRentAvailable() {
        assertThat(BookRentStatus.RENT_AVAILABLE.isRent()).isTrue();
    }

    @Test
    @DisplayName("렌트가 불가능한 상태 여부 테스트")
    void testRentAlready() {
        assertThat(BookRentStatus.RENT_ALREADY.isRent()).isFalse();
    }
}
