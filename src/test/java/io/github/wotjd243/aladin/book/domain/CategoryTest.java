package io.github.wotjd243.aladin.book.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import org.junit.Test;

public class CategoryTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_카테고리_생성() {

        //given
        Category category = new Category("");
    }

    @Test
    public void 정상적인_카테고리_생성() {

        //given
        Category category = new Category("IT");
    }
}
