package io.github.wotjd243.findbyhint.mission.domain;

import io.github.wotjd243.findbyhint.util.RandomUtils;

public class SuccessMissionService {

    private static int LEVEL = 1;
    private static final int RANDOM_INT = RandomUtils.nextInt(9);

    private final Mission mission;


    public SuccessMissionService(final Mission mission) {
        this.mission = mission;
    }

    public int isSuccess() {
        return takePoint();
    }

    private int takePoint() {
        return LEVEL * RANDOM_INT;
    }


}
