package io.github.wotjd243.aladin.book.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import org.junit.Test;

public class PublisherTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_출판사_생성() {

        //given
        Publisher publisher = new Publisher("");
    }

    @Test
    public void 정상적인_출판사_생성() {

        //given
        Publisher publisher = new Publisher("한빛미디어");
    }

}
