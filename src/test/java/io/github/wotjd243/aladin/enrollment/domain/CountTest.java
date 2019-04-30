package io.github.wotjd243.aladin.enrollment.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.exception.WrongValueException;
import org.junit.Test;

public class CountTest {

    @Test(expected = NotFoundException.class)
    public void 비정상적인_권수없음() {

        //given
        Count count = new Count(null);
    }

    @Test(expected = WrongValueException.class)
    public void 비정상적인_권수_minus3() {

        //given
        Count count = new Count(-3L);
    }

    @Test
    public void 정상적인_권수_3() {

        //given
        Count count = new Count(3L);
    }
}
