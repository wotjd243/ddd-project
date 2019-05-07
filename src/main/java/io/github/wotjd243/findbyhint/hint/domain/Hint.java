package io.github.wotjd243.findbyhint.hint.domain;
//TODO 1. 힌트 에그리거트는 헌터ID, 보물ID, 좌표값, 순서로 이루어져 있다.
//TODO 2. Treasure에 해당하는 Tartgetpoint를 가져오는 메서드  ( HintService에서 Delete 메서드 실행시 보물의 좌표를 제외하고 지워야함 )




import io.github.wotjd243.findbyhint.hunter.domain.HunterId;
import io.github.wotjd243.findbyhint.treasure.domain.TargetPoint;

import java.util.List;

public class Hint {
    // 힌트 엔티티의 PK
    private Long HintId;
    // FK
    private final HunterId hunterId;
    // FK 나중에 주입받는다 .(referenced Column ID)
    private final Long treasureId;
    // targetPointList 에서 추출할 값은 latitude , hardness , distinguish , hintOrder => (TargetPoint 의 PK값)


    private final List<TargetPoint> targetPointList;



    public Hint(String hunterId, Long treasureId, List<TargetPoint> targetPointList) {
        this.hunterId = new HunterId(hunterId);
        this.treasureId = treasureId;
        this.targetPointList = targetPointList;
    }

    public static Hint valueOf(String hunterId, Long treasureId, List<TargetPoint> targetPointList) {
        return new Hint(hunterId, treasureId, targetPointList);
    }




}