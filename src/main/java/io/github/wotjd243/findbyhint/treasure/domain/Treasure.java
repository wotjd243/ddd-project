package io.github.wotjd243.findbyhint.treasure.domain;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class Treasure {

    // TODO (2) 보물의 위치 : 위도 경도 VO로 만들기
    // TODO (3) 러닝타임 : 시작일 종료일 VO로 만들기

    private Long id;

    //보물의 이름
    private String name;

    //보물로 접근할 수 있는 QR코드
    private String qrCode;

    //현재상태
    private String runningStatus;

    private TargetPoint targetPoint;

    private RunningTime runningTime;

<<<<<<< HEAD

    private Treasure(Long id, String name, String qrCode, String runningStatus,final String latitude,final String hardness,
                     final LocalDate startDate,final LocalDate endDate) {

        validation(id,name,qrCode,runningStatus);
        this.id = id;
        this.name = name;
        this.qrCode = qrCode;
        this.runningStatus = runningStatus;
        this.targetPoint= TargetPoint.valueOfIatitudeAndHardness (latitude,hardness);
        this.runningTime = RunningTime.valueOfStartDateAndEndDate(startDate,endDate);
    }

    public static Treasure valueOf(Long id, String name, String qrCode, String runningStatus,
                                   String latitude,final String hardness,
                                   final LocalDate startDate,final LocalDate endDate){
        return new Treasure(id,name,qrCode,runningStatus,latitude,hardness,startDate,endDate);
    }

    public void validation(Long id, String name, String qrCode, String runningStatus){
        if(id == null || StringUtils.isEmpty(name)|| StringUtils.isEmpty(qrCode)|| StringUtils.isEmpty(runningStatus)){
            new IllegalArgumentException("Treasure 에서 예외 발생");
=======
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
>>>>>>> afac6cd... *docs README 문서 수정
        }
    }
    public String TreasureInfo() {
        return "Treasure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", runningStatus='" + runningStatus + '\'' +
                ", targetPoint=" + targetPoint.getTargetPoint().get("latitude") + targetPoint.getTargetPoint().get("hardness") + '\'' +
                ", runningTime=" + runningTime.getRunningTime().get("startDate") + runningTime.getRunningTime().get("endDate") + '\'' +
                '}';
    }
}
