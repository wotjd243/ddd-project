package io.github.wotjd243.findbyhint.treasure.domain;

import org.junit.Test;


import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TargetPointTest {

    @Test
    public void 보물지점생성_정상(){
        // given
        TargetPoint.valueOfIatitudeAndHardness("37.4954676","126.9941658");

        // when

        // then

    }

    @Test(expected = IllegalArgumentException.class)
    public void 보물지점생성_위도가없을때(){
        // given
        String latitude = null;
        String hardness = "37.4954676";

        // when
        TargetPoint.valueOfIatitudeAndHardness(latitude,hardness);

        // then

    }

    @Test(expected = IllegalArgumentException.class)
    public void 보물지점생성_경도가없을때(){
        // given
        String latitude = "37.4954676";
        String hardness = null;

        // when
        TargetPoint.valueOfIatitudeAndHardness(latitude,hardness);

        // then
    }

}