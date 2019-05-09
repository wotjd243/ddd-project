package io.github.book.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Account 객체 테스트")
class UserTest {

    @Test
    @DisplayName("User 객체 생성 실패")
    public void createUserFailTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User.builder()
                    .name("Tram")
                    .email("")
                    .password("1234")
                    .phoneNumber("010-1111-1111")
                    .birthDay(LocalDate.now())
                    .build();
        });
    }

    @Test
    @DisplayName("User 객체 생성 성공")
    public void createUserSuccessTest() {
        User user = User.builder()
                .name("Tram")
                .email("google@gmail.com")
                .password("1234")
                .phoneNumber("010-1111-1111")
                .birthDay(LocalDate.now())
                .build();
        assertThat(user).isNotNull();
    }
}
