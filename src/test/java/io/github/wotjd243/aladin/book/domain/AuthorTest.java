package io.github.wotjd243.aladin.book.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import org.junit.Test;

public class AuthorTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_저자_생성() {

        //given
        Author author = new Author("");
    }

    @Test
    public void 정상적인_저자_생성() {

        //given
        Author author = new Author("권세희");
    }

}
