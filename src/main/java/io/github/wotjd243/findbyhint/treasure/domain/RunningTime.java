package io.github.wotjd243.findbyhint.treasure.domain;

import io.github.wotjd243.findbyhint.util.check.DateObject;

import java.time.LocalDate;
import java.time.Period;

public class RunningTime {

    // TODO (1) 보물이 생성될때 러닝타임의 시작일과 종료일은 생성 시간보다 같거나 늦으며, 시작일은 종료일보다 빠르다.
    // TODO (2) 러닝타임의 길이를 구하는 기능
    // TODO (3) 풀어야하는‘미션’의 가지수는‘러닝 타임’에 길이에 따라 결정된다.

    // 러닝타임 시작일
    private final LocalDate startDate;
    // 러닝타임 종료일
    private final LocalDate endDate;

    private RunningTime(LocalDate startDate, LocalDate endDate) {

        HashMap<String,LocalDate> valueNMap = new HashMap<String,LocalDate>();
        valueNMap.put("startDate",startDate);
        valueNMap.put("endDate",endDate);

        validation(valueNMap);


        this.startDate = startDate;
        this.endDate = endDate;
    }


    public static RunningTime valueOfStartDateAndEndDate (final LocalDate startDate,final LocalDate endDate){
        return new RunningTime(startDate,endDate);
    }


    //validation
<<<<<<< HEAD
    private void validation(HashMap<String,LocalDate> valueMap){
        if(!(nullCheck(valueMap) && dateValidation(valueMap))){
            throw new IllegalArgumentException("RunningTime 에서 발생");
=======
    private void validation(final LocalDate startDate,final LocalDate endDate){
        if(!(nullCheck(startDate,endDate) && dateValidation(startDate,endDate))){
            throw new IllegalArgumentException("RunningTime Exception !!!");
>>>>>>> afac6cd... *docs README 문서 수정
        }
    }


    //nullCHeck
    private Boolean nullCheck(HashMap<String,LocalDate> valueMap){
        LocalDate startDate = valueMap.get("startDate");
        LocalDate endDate = valueMap.get("endDate");
        Boolean check = true;
        if(startDate == null || endDate == null){
            check = false;
            throw new IllegalArgumentException("시작일자나 종료일자가 없습니다.");
        }
        return check;
    }

    //종료일이 시작일 보다 빠른가에 대한 체크
    private Boolean dateValidation(HashMap<String,LocalDate> valueMap){
        Boolean check = true;

        //현재 날짜
        DateObject today = new DateObject();

        //파라미터 날짜
        LocalDate startDate = valueMap.get("startDate");
        LocalDate endDate = valueMap.get("endDate");

        System.out.println("--------------------------------------------------------------");
        System.out.println("in the RunningTime dateValidation");
        System.out.println("startDate.compareTo(today.getDate()) :: "+ startDate.compareTo(today.getDate()));
        System.out.println("endDate.compareTo(today.getDate()) :: "+ endDate.compareTo(today.getDate()));
        System.out.println("endDate.compareTo(startDate) :: "+ endDate.compareTo(startDate));
        System.out.println("--------------------------------------------------------------");

        System.out.println("startDate 가 현재 날짜보다 이른다 " +startDate.isAfter(today.getDate()));
        System.out.println("endDate 가 현재 날짜보다 이른다 " +endDate.isAfter(today.getDate()));
        System.out.println("endDate 가 startDate 보다 날짜보다 이른다 " +endDate.isAfter(startDate));

        if(!((startDate.isAfter(today.getDate()) || startDate.isEqual(today.getDate())) && endDate.isAfter(today.getDate())  && endDate.isAfter(startDate))){
            check =false;
            throw new IllegalArgumentException("러닝 타임 validation 잘못 설정");
        }

        return check;
    }



    //러닝타임을 구하는 기능
    public int getRunningRangeDays(){
        //일수 차이
        Period runningRangePeriod = Period.between(this.startDate,this.endDate);
        //설명변수
        int runningRangeDays = runningRangePeriod.getDays();
        return runningRangeDays;
    }


    //러닝타임의 따라 풀어야 하는 미션의 개수
    // 공식 :  1주일에 개의 문제  7일당 5문제
    public int getMissionCountByRunningRangeDays(){
        int runningRangeDays = getRunningRangeDays();
<<<<<<< HEAD
        int countByRunningRangeDays  = runningRangeDays  - runningRangeDays/7 * 2;
        return countByRunningRangeDays;
=======
        //설명변수
        int missionCount = runningRangeDays  - runningRangeDays/7 * 2;
        return missionCount;
>>>>>>> afac6cd... *docs README 문서 수정
    }

    public String runningTimeInfo() {
        return "RunningTime{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public HashMap getRunningTime(){
        HashMap map = new HashMap();
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        return map;
    }

}
