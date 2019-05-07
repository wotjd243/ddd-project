package io.github.wotjd243.findbyhint.treasure.domain;

import io.github.wotjd243.findbyhint.mission.domain.Mission;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Treasure {

    // TODO (2) 보물의 위치 : 위도 경도 VO로 만들기
    // TODO (3) 러닝타임 : 시작일 종료일 VO로 만들기

    private Long treasureId;

    //보물의 이름
    private String treasureName;

    //현재상태
    private String runningStatus;

    private List<TargetPoint> targetPointList;

    private RunningTime runningTime;

    //보물로 접근할 수 있는 QR코드
    private QRCodeVO qrCodeVO;

    private List<Mission> missionList;

    public Treasure(String treasureName,
                    String runningStatus, QRCodeVO qrCodeVO,
                    List<TargetPoint> targetPointList,
                    RunningTime runningTime,
                    final List<Mission> missionList) {
        validation(treasureName,runningStatus,targetPointList,runningTime,missionList);
        this.treasureId = UUID.randomUUID().getMostSignificantBits();
        this.treasureName= treasureName;
        this.runningStatus = runningStatus;
        this.qrCodeVO = qrCodeVO;
        this.targetPointList= targetPointList;
        this.runningTime = runningTime;
        this.missionList = missionList;
    }

    public static Treasure valueOf(String treasureName, QRCodeVO qrCodeVO,
                                   String runningStatus,
                                   List<TargetPoint> targetPointList,
                                   RunningTime runningTime,
                                   List<Mission> missionList){
        return new Treasure(treasureName,runningStatus,qrCodeVO,targetPointList,runningTime,missionList);
    }

    public void validation(String name, String runningStatus,  List<TargetPoint> targetPointList,RunningTime runningTime, List<Mission> missionList ){
        if(missionList.isEmpty()|| StringUtils.isEmpty(name)|| StringUtils.isEmpty(runningStatus) || targetPointList.isEmpty() || runningTime == null) {
            new IllegalArgumentException("Treasure Exception !!!");
        }
    }

}
