package io.github.book.domain.book.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Author 객체 관련 테스트")
class AuthorTest {

    @Test
    void 작가_객체_생성_실패_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Author.builder().authorName("").authorAge(1).build();
        });
    }

    @Test
    void 작가_객체_생성_성공_테스트() {
        String name = "이학선";
        Author author = Author.builder().authorName(name).authorAge(1).build();
        assertThat(author.getAuthorName()).isEqualTo(name);
    }
}
