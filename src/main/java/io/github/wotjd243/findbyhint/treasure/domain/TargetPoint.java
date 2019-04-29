package io.github.wotjd243.findbyhint.treasure.domain;

import org.springframework.util.StringUtils;

import java.util.HashMap;

public class TargetPoint {

    /*실제 보물의 위치*/
    //위도
    private final String latitude;

    //경도
    private final String hardness;

    private TargetPoint(String latitude, String hardness) {
        validation(latitude,hardness);
        this.latitude = latitude;
        this.hardness = hardness;

    }

    public static TargetPoint valueOfIatitudeAndHardness (final String latitude,final String hardness){
    return new TargetPoint(latitude,hardness);
}

    //nullCHeck
    public void validation(final String latitude,final String hardness){
        if(StringUtils.isEmpty(latitude) || StringUtils.isEmpty(hardness)){
            throw new IllegalArgumentException("TargetPoint 지점에서 발생");
        }
    }

    public HashMap getTargetPoint(){
        HashMap targetPointMap = new HashMap();
        targetPointMap.put("latitude",this.latitude);
        targetPointMap.put("hardness",this.hardness);
        return targetPointMap;
    }
}

