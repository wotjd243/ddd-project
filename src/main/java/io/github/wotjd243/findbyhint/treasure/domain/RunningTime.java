package io.github.wotjd243.findbyhint.treasure.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.HashMap;

public class RunningTime {

    // 러닝타임 시작일
    private final LocalDate startDate;
    // 러닝타임 종료일
    private final LocalDate endDate;

    private RunningTime(LocalDate startDate, LocalDate endDate) {

        validation(startDate,endDate);


        this.startDate = startDate;
        this.endDate = endDate;
    }


    public static RunningTime valueOfStartDateAndEndDate (final LocalDate startDate,final LocalDate endDate){
        return new RunningTime(startDate,endDate);
    }


    //validation
    private void validation(final LocalDate startDate,final LocalDate endDate){
        if(!(nullCheck(startDate,endDate) && dateValidation(startDate,endDate))){
            throw new IllegalArgumentException("RunningTime 에서 발생");
        }
    }


    //nullCHeck
    private Boolean nullCheck(LocalDate startDate, LocalDate endDate){
        Boolean check = true;
        if(startDate == null || endDate == null){
            check = false;
        }
        return check;
    }

    //종료일이 시작일 보다 빠른가에 대한 체크
    private Boolean dateValidation(LocalDate startDate, LocalDate endDate){
        Boolean check = true;

        //현재 날짜
        DateObject today = new DateObject();

        //파라미터 날짜

        System.out.println("--------------------------------------------------------------");
        System.out.println("in the RunningTime dateValidation");
        System.out.println("startDate.compareTo(today.getDate()) :: "+ startDate.compareTo(today.getDate()));
        System.out.println("endDate.compareTo(today.getDate()) :: "+ endDate.compareTo(today.getDate()));
        System.out.println("endDate.compareTo(startDate) :: "+ endDate.compareTo(startDate));
        System.out.println("--------------------------------------------------------------");

        System.out.println("startDate 가 현재 날짜보다 이른다 " +startDate.isAfter(today.getDate()));
        System.out.println("endDate 가 현재 날짜보다 이른다 " +endDate.isAfter(today.getDate()));
        System.out.println("endDate 가 startDate 보다 날짜보다 이른다 " +endDate.isAfter(startDate));

        if(!(startDate.isAfter(today.getDate()) && endDate.isAfter(today.getDate())  && endDate.isAfter(startDate))){
            check =false;
        }

        return check;
    }



    //러닝타임을 구하는 기능
    public int getRunningRangeDays(){
        //일수 차이
        Period runningRangePeriod = Period.between(this.startDate,this.endDate);
        int runningRangeDays = runningRangePeriod.getDays();
        return runningRangeDays;
    }


    //러닝타임의 따라 풀어야 하는 미션의 개수
    // 공식 :  1주일에 개의 문제  7일당 5문제
    public int getCountByRunningRangeDays(){
        int runningRangeDays = getRunningRangeDays();
        return runningRangeDays  - runningRangeDays/7 * 2;
    }

    public String runningTimeInfo() {
        return "RunningTime{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
