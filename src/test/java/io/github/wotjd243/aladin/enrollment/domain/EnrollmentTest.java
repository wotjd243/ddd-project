package io.github.wotjd243.aladin.enrollment.domain;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class EnrollmentTest {

    @Test
    public void 이벤트없이_만원짜리_같은책_세권등록() {
        //given
        Enrollment enrollment = Enrollment.of(1L, 1L, 3L, 10000L);
        //expect
        assertThat(enrollment.getRegisteredBooks().size()).isEqualTo(3);
        assertThat(enrollment.getEvent().getStartDate()).isNull();
        assertThat(enrollment.getEvent().getEndDate()).isNull();
        assertThat(enrollment.getEvent().getPeriodPercent()).isNull();
        //then
    }

    @Test
    public void 이벤트있는_만원짜리_같은책_세권등록() {
        //given
        Enrollment enrollment = Enrollment.ofWithEvent(1L, 1L, 3L, 10000L, LocalDate.of(2019, 4, 22), LocalDate.of(2019, 4, 24), 3.0);
        //expect
        assertThat(enrollment.getRegisteredBooks().size()).isEqualTo(3);
        assertThat(enrollment.getEvent().getStartDate()).isEqualTo(LocalDate.of(2019, 4, 22));
        assertThat(enrollment.getEvent().getEndDate()).isEqualTo(LocalDate.of(2019,4, 24));
        assertThat(enrollment.getEvent().getPeriodPercent()).isEqualTo(3.0);
        //then
    }
}
