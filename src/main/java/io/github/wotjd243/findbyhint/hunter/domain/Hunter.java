package io.github.wotjd243.findbyhint.hunter.domain;

public class Hunter {

    // TODO (1)‘헌터’는 하루에 미션 하나를 풀 수 있고 기회는 3번이다.
    // TODO (2)‘헌터' 는 미션 포인트를 100점 모으면 문제를 풀 수 있는 총알을 하나 얻는다.
    // TODO (3)‘헌터' 가 미션을 풀 수있는 기회의 수는 총알이다. 관련된 객체 생성하기.

    private final HunterId hunterId;

    private final HunterPw hunterPw;

    private final HunterName hunterName;

    private final String hunterPicturePath;

    private final HunterPictureName hunterPictureName;

    private final HunterPoint hunterPoint;

    Hunter(String hunterId, String hunterPw, String hunterName, String hunterPicturePath, String hunterPictureName, int hunterPoint) {
        this.hunterId = new HunterId(hunterId);
        this.hunterPw = new HunterPw(hunterPw);
        this.hunterName = new HunterName(hunterName);
        this.hunterPicturePath = hunterPicturePath;
        this.hunterPictureName = new HunterPictureName(hunterPictureName);
        this.hunterPoint = new HunterPoint(hunterPoint);
    }

}
