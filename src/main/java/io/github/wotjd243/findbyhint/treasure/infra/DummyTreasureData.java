package io.github.wotjd243.findbyhint.treasure.infra;

import io.github.wotjd243.findbyhint.mission.domain.Mission;
import io.github.wotjd243.findbyhint.mission.domain.MissionLevel;
import io.github.wotjd243.findbyhint.treasure.domain.QRCodeVO;
import io.github.wotjd243.findbyhint.treasure.domain.RunningTime;
import io.github.wotjd243.findbyhint.treasure.domain.TargetPoint;
import io.github.wotjd243.findbyhint.treasure.domain.Treasure;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class DummyTreasureData {

    private static final Map<Long, Treasure> data = new HashMap<>();

    static {
        
        QRCodeVO qrCodeVO= new QRCodeVO("https://blog.naver.com/doyoung0205",300,300,"0xff000000","0xffffffff","비밀번호");
        final Long treasureId = 1L;
        final String treasureName = "보물이름";
        final String runningStatus = "대기";

        final LocalDate startDate = LocalDate.now();
        final LocalDate endDate = LocalDate.of(2020,12,12);
        RunningTime runningTime = RunningTime.valueOfStartDateAndEndDate(startDate,endDate);

        List<TargetPoint> targetPointList = new ArrayList<>();
        Double latitude = 37.4954388;
        Double hardness = 127.0292711;

        //실제 보물의 위치
        TargetPoint realTargetPoint = TargetPoint.valueOfIatitudeAndHardness(latitude,hardness,"1");
        targetPointList.add(realTargetPoint);

        //해당 미션 카운트 만큼 미션 생성
        final List<Mission> missionList = new ArrayList<>();
        int missionCount = runningTime.getMissionCountByRunningRangeDays();
        int hinterCounter = 0;
        for (int i = 3; i > 0; i--) {
            for (int i2 = 1; i2 <= i; i2++) {

                switch (i2) {
                    case 1:
                        Mission mission = new Mission(missionCount, "브론즈문제인가", "맞다", MissionLevel.EASY, 0);
                        hinterCounter += mission.getMissionLevel().getHintCounter();
                        missionList.add(mission);
                        break;
                    case 2:
                        Mission mission2 = new Mission(missionCount, "실버 문제인가", "맞다", MissionLevel.MEDIUM, 0);
                        hinterCounter += mission2.getMissionLevel().getHintCounter();
                        missionList.add(mission2);
                        break;
                    case 3:
                        Mission mission3 = new Mission(missionCount, "골드 문제인가", "맞다", MissionLevel.HARD, 0);
                        hinterCounter += mission3.getMissionLevel().getHintCounter();
                        missionList.add(mission3);
                        break;
                }
                if (i == 1) {
                    i = 3;
                    i2 = 0;
                }
                missionCount--;

                if (missionCount == 0) {
                    break;
                }
            }
            if (missionCount == 0) {
                break;
            }
        }

         // 가짜 보물의 위치 생성
        IntStream.range(1,hinterCounter).forEach(i ->{
            targetPointList.add(realTargetPoint.getFakeTargetPoint());
        });


        put(treasureId, treasureName,
                runningStatus, qrCodeVO,
                targetPointList,
                runningTime,
                missionList);
    }

    public static Treasure get(final Long key) {
        return data.get(key);
    }

    private static Treasure put(Long treasureId, String treasureName,
                                String runningStatus, QRCodeVO qrCodeVO,
                                List<TargetPoint> targetPointList,
                                RunningTime runningTime,
                                final List<Mission> missionList) {

        return data.put(treasureId,new Treasure(treasureName,runningStatus,qrCodeVO,targetPointList,runningTime,missionList));

    }
}
