package io.github.wotjd243.findbyhint.mission.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MissionTest {

    @Test
    public void 미션_생성() {
        // given
        // when
        // then
        new Mission(1,"미션 문제 테스트", "미션 답 테스트",MissionLevel.EASY,70);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 다이아_레벨_미션_생성() {
        new Mission(2,"미션 문제 테스트", "미션 답 테스트",MissionLevel.HARD, 30);
    }




}