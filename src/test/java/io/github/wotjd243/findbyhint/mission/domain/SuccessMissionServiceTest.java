package io.github.wotjd243.findbyhint.mission.domain;

import io.github.wotjd243.findbyhint.mission.application.MissionService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SuccessMissionServiceTest {
    private static final Mission TEST_MISSION_EASY_TAKE_POINT = new Mission(1, "Brian May was the guitarist for which band?", "Queen", MissionLevel.EASY, 0);
    private static final Mission TEST_MISSION_HARD_TAKE_POINT = new Mission(2, "Before Super Smash Bros. contained Nintendo characters, what was it known as internally?", "Dragon King: The Fighting Game", MissionLevel.HARD, 0);

    @Test
    public void 쉬운_문제_맞췄을때() {
        //given
        final SuccessMissionService successMissionService = new SuccessMissionService(TEST_MISSION_EASY_TAKE_POINT);

        //when
        final int point = successMissionService.isSuccess();

        //then
        assertThat(point).isNotZero();
        System.out.println("point: "+point);
    }

    @Test
    public void 어려운_문제_맞췄을때() {
        //given
        final SuccessMissionService successMissionService = new SuccessMissionService(TEST_MISSION_HARD_TAKE_POINT);

        //when
        final int point = successMissionService.isSuccess();

        //then
        assertThat(point).isNotZero();
        System.out.println("point: "+point);
    }



}