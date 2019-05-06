package io.github.book.domain.user.domain;

import io.github.book.domain.book.domain.Author;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Account 객체 테스트")
class AccountTest {

    @Test
    @DisplayName("계정 객체 생성 실패 테스트(email 문제)")
    void createAccountFailTest1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account.builder().email("").password("").build();
        });
    }

    @Test
    @DisplayName("계정 객체 생성 실패 테스트(비밀번호 문제)")
    void createAccountFailTest2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account.builder().email("").password("").build();
        });
    }

    @Test
    @DisplayName("계정 객체 생성 성공 테스트")
    void createAccountSuccessTest() {
        String name = "이학선";
        Author author = Author.builder().authorName(name).authorAge(1).build();
        assertThat(author.getAuthorName()).isEqualTo(name);
    }
}