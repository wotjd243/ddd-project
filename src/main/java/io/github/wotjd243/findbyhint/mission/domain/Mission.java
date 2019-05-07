package io.github.wotjd243.findbyhint.mission.domain;

public class Mission {
    // TODO (1) '미션’은 난이도가 4개가 있다. (브론즈, 실버, 골드, 플래티넘)
    // TODO (2) '미션' 은 Easy일 경우 브론즈, 실버 난이도로, Medium일 경우 골드 난이도로, Hard일 경우 플래티넘 난이도로 레벨이 적용된다.
    // TODO (3)‘미션’을 러닝타임 시간안에 푸는데 성공하면 거기에 맞는 힌트를 제공한다. --보물, 힌트도메인과 연관
    // TODO (4)‘미션’을 푸는데 성공하면 다음 난이도에 도전할 수 있다.
    // TODO (5)‘미션’은 누군가 보물의 QR코드를 접속하면 종료된다.->보물도메인에서
    // TODO (6) '미션 포인트'는 최대 100점을 넘을 수 없다.

    //미션키
    private final int missionKey;
    //미션 문제
    private final String question;
    //미션 답
    private final String answer;
    //미션 난이도
    private MissionLevel missionLevel;
    //미션 난이도
//    private final MissionLevel level;

    //미션성공시 증정 포인트
    private final MissionPoint point;

    /*public Mission(final int missionKey, final String question, final String answer, final String level, final int point) {
        validation(question, answer, level);
        this.missionKey = missionKey;
        this.question = question;
        this.answer = answer;
        this.missionLevel = MissionLevel.valueOf(missionLevel);
//        this.level = new MissionLevel(level);
        this.point = MissionPoint.valueOf(point);
    }*/

    public Mission(int missionKey, String question, String answer, MissionLevel missionLevel, final int point) {
        this.missionKey = missionKey;
        this.question = question;
        this.answer = answer;
        this.missionLevel = missionLevel;
        this.point = MissionPoint.valueOf(point);
    }

    public void validation(final String question, final String answer, final String level) {
        if(question == null || answer == null || level == null) {
            throw new IllegalArgumentException();
        }

    }

    public MissionLevel getMissionLevel() {
        return missionLevel;
    }

}
