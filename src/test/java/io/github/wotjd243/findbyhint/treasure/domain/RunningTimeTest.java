package io.github.wotjd243.findbyhint.treasure.domain;

import io.github.wotjd243.findbyhint.util.check.DateObject;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class RunningTimeTest {

    @Test
    public void 러닝타임생성_정상() {
        // given
        DateObject dateObject = new DateObject();
        LocalDate startDate = dateObject.getDate().plusDays(10L);
        LocalDate endDate = dateObject.getDate().plusDays(11L);

        // when
        RunningTime.valueOfStartDateAndEndDate(startDate,endDate);

        // then

    }

    @Test(expected = IllegalArgumentException.class)
    public void 러닝타임생성_오늘날짜보다_이전인경우() {
        // given
        DateObject dateObject = new DateObject();
        LocalDate startDate = dateObject.getDate().minusDays(10L);
        LocalDate endDate = dateObject.getDate().minusDays(13L);

        // when
        RunningTime.valueOfStartDateAndEndDate(startDate,endDate);

        // then

    }
    @Test(expected = IllegalArgumentException.class)
    public void 러닝타임생성_종료날짜가_시작날짜보다_이전인경우() {
        // given
        DateObject dateObject = new DateObject();
        LocalDate startDate = dateObject.getDate().plusDays(12L);
        LocalDate endDate = dateObject.getDate().plusDays(11L);

        // when
        RunningTime.valueOfStartDateAndEndDate(startDate,endDate);

        // then

    }

    @Test
    public void 러닝타임기간가져오기() {
        // given
        DateObject dateObject = new DateObject();
        int startDays = 11;
        int endDays = 12;
        int distance = endDays - startDays;

        LocalDate startDate = dateObject.getDate().plusDays(startDays);
        LocalDate endDate = dateObject.getDate().plusDays(endDays);

        // when
        RunningTime runningTime = RunningTime.valueOfStartDateAndEndDate(startDate,endDate);

        int runningRangeDays = runningTime.getRunningRangeDays();

        // then
        assertThat(runningRangeDays).isEqualTo(distance);
    }

    @Test
    public void 러닝타임의_따라_풀어야_하는_미션의_개수() {
        // given
        DateObject dateObject = new DateObject();
        int startDays = 1;
        int endDays = 15;

        int distance = endDays - startDays;
        int expectedCount = distance - distance/7*2;

        LocalDate startDate = dateObject.getDate().plusDays(startDays);
        LocalDate endDate = dateObject.getDate().plusDays(endDays);

        // when
        RunningTime runningTime = RunningTime.valueOfStartDateAndEndDate(startDate,endDate);
        int countByRunningRangeDays = runningTime.getMissionCountByRunningRangeDays();

        assertThat(countByRunningRangeDays).isEqualTo(expectedCount);
    }


}