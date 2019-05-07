package io.github.wotjd243.findbyhint.treasure.domain;

import org.junit.Test;


import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TargetPointTest {

    @Test
    public void 보물지점생성_정상(){
        // given
        TargetPoint.valueOfIatitudeAndHardness(37.4954676,126.9941658,"1");

        // when

        // then

    }

    @Test(expected = IllegalArgumentException.class)
    public void 보물지점생성_위도가없을때(){
        // given
        Double latitude = null;
        Double hardness = 37.4954676;
        String distinguish = "1";

        // when
        TargetPoint.valueOfIatitudeAndHardness(latitude,hardness,distinguish);

        // then

    }

    @Test(expected = IllegalArgumentException.class)
    public void 보물지점생성_경도가없을때(){
        // given
        Double latitude = 37.4954676;
        Double hardness = null;
        String distinguish = "1";
        // when
        TargetPoint.valueOfIatitudeAndHardness(latitude,hardness,distinguish);

        // then
    }

}