package io.github.wotjd243.findbyhint.hint.domain;
import io.github.wotjd243.findbyhint.treasure.domain.TargetPoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HintTest {
    @Test
    public void 힌트생성(){
        // given
        final Long HintId = 4L;
        final String HunterId = "ylips";
        final Long treasureId = 3L;
        final List<TargetPoint> targetPointList = new ArrayList<>();

        TargetPoint realTargetPoint= TargetPoint.valueOfIatitudeAndHardness(34.323,125.3213,"3");

        targetPointList.add(realTargetPoint);
        for(int i=0; i<4; i++){
            TargetPoint fakeTargetPoint = realTargetPoint.getFakeTargetPoint();
            targetPointList.add(fakeTargetPoint);
        }




        // when
        Hint result = Hint.valueOf(HunterId,treasureId,targetPointList);

        // then
    }




}