package io.github.book.book.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Book 객체 테스트")
class BookTest {
    private Book book;
    private Author author;

    @BeforeEach
    public void setup(){
        author = new Author("조영호", 39);
        book = new Book("978-89-9813-976-6", "객체지향의 사실과 오해", author, "올 하반기에 다음시리즈 나온다던데 기대 중", LocalDate.now());
    }


    @Test
    @DisplayName("키워드가 제목에 포함되어 있는 경우(title과 똑같은 값 입력)")
    public void matchTitleSuccessTest(){
        assertThat(book.isContainsTitle("객체지향의 사실과 오해")).isTrue();
    }

    @Test
    @DisplayName("키워드가 제목에 포함되어 있는 경우(title의 일부 값 입력)")
    public void matchTitleSuccessTest2(){
        assertThat(book.isContainsTitle("객체지향의")).isTrue();
    }

    @Test
    @DisplayName("키워드가 제목에 포함되어 있지 않는 경우")
    public void matchTitleFalseTest(){
        assertThat(book.isContainsTitle("앨리스")).isFalse();
    }
}
