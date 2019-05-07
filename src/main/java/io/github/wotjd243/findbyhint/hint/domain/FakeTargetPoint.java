package io.github.wotjd243.findbyhint.hint.domain;

import org.springframework.util.StringUtils;

import java.util.HashMap;

public class FakeTargetPoint {



    private final String latitude;
    private final String hardness;

    public FakeTargetPoint(final String latitude, final String hardness) {

        this.latitude = latitude;
        this.hardness = hardness;
    }

    public static FakeTargetPoint valueOffakeTargetPoint(final String latitude, final String hardness) {
        return new FakeTargetPoint(latitude, hardness);
    }



    //nullCHeck
    public void validation(final String latitude, final String hardness) {
        if (StringUtils.isEmpty(latitude) || StringUtils.isEmpty(hardness)) {
            throw new IllegalArgumentException("FakeTargetPoint 지점에서 발생");
        }
    }

    public HashMap getFakeTargetPoint() {
        HashMap faketargetPointMap = new HashMap<>();
        faketargetPointMap.put("latitude", this.latitude);
        faketargetPointMap.put("hardness", this.hardness);
        return faketargetPointMap;
    }
}
