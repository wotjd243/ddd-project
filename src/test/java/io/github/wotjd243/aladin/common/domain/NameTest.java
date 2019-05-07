package io.github.wotjd243.aladin.common.domain;

import io.github.wotjd243.aladin.common.domain.Name;
import io.github.wotjd243.aladin.exception.NotFoundException;
import org.junit.Test;

public class NameTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_이름없음() {

        //given
        Name name = new Name("");
    }

    @Test
    public void 정상적인_이름_이호진() {

        //given
        Name name = new Name("이호진");
    }
}
