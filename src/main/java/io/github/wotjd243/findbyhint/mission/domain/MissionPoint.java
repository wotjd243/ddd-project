package io.github.wotjd243.findbyhint.mission.domain;

public class MissionPoint {

    private int point;
    public MissionPoint(final int point) {
//        randomPoint(point);
        validate(point);
        this.point = point;
    }

    //static 팩토리 메소드(정적 팩토리메소드)
    public static MissionPoint valueOf(final int point) {
        return new MissionPoint(point);
    }

    //랜덤숫자 생성
    /*public int randomPoint(int point) {
        double randomPoint = Math.random();
        point = (int) (randomPoint * 100) +1;
        System.out.println(point);
        return point;
    }*/

    //유효성 검사
    private void validate(final int point) {
        if(point < 0 || point > 100) {
            throw new IllegalArgumentException();
        }
    }
}
