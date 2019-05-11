package io.github.wotjd243.findbyhint.treasure.domain;

import org.springframework.util.StringUtils;

import java.util.Random;
import java.util.function.DoubleUnaryOperator;

// TODO (1) 경도(Hardness)범위는 124 – 132, 위도(Latitude)범위는 33 – 43 안에 범주한다.

public class TargetPoint {

    private Long targetPointId;

    /*실제 보물의 위치*/
    //위도
    private final Double latitude;

    //경도
    private final Double hardness;

    //진짜 가짜 유무
    private final String distinguish;

    private TargetPoint(Double latitude, Double hardness,String distinguish) {
        validation(latitude,hardness,distinguish);
        this.latitude = latitude;
        this.hardness = hardness;
        this.distinguish =distinguish;
    }

    public static TargetPoint valueOfIatitudeAndHardness (final Double latitude,final Double hardness,final String distinguish){
        return new TargetPoint(latitude,hardness,distinguish);
    }

    // TODO (1) 경도(Hardness)범위는 124 – 132, 위도(Latitude)범위는 33 – 43 안에 범주한다.

    //nullCHeck
    public void validation(final Double latitude,final Double hardness,final String distinguish){

        if(latitude == null || hardness ==null || StringUtils.isEmpty(distinguish)){
            throw new IllegalArgumentException("TargetPoint Exception !!!");
        }else if (latitude < 33 || latitude > 43 ||  hardness < 124 || hardness > 132){
            throw new IllegalArgumentException("경도와 위도범위가 맞지 않음 " + "경도 (hardness) :" + hardness + "위도(latitude) : "+latitude);
        }

    }

    public TargetPoint getFakeTargetPoint(){
        Random random = new Random();
        Double latitude = 33 + random.nextInt(10) +random.nextDouble();
        Double hardness = 124 + random.nextInt(8) +random.nextDouble();
        return TargetPoint.valueOfIatitudeAndHardness(latitude,hardness,"0");
    }

    public Double getHardness() {
        return hardness;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getDistinguish() {
        return distinguish;
    }
}

