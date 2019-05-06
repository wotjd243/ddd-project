package io.github.wotjd243.findbyhint.hint.domain;

import io.github.wotjd243.findbyhint.mission.domain.MissionLevel;

public class Hint {


    private HintId number;
    private MissionLevel level;
    private FakeTargetPoint fakeTargetPoint;


    public Hint(final int number, final String level, final String latitude,final String hardness) {
        this.number = HintId.valueOf(number);
        this.level = MissionLevel.valueOfmissonLevel(level);
        this.fakeTargetPoint= FakeTargetPoint.valueOffakeTargetPoint(latitude , hardness);
    }



    public static Hint valueOf(int number, String level, String latitude, final String hardness){
        return new Hint(number,level,latitude,hardness);
    }


    public String HintInfo() {
        return "Hint{" +
                "number=" + number +
                ", level='" + level + '\'' +
                ", targetPoint=" + fakeTargetPoint.getFakeTargetPoint().get("latitude") + fakeTargetPoint.getFakeTargetPoint().get("hardness") + '\'' +
                '}';
    }






}

