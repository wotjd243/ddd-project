package io.github.wotjd243.findbyhint.hunter.domain;

public class Hunter {

    // TODO (1) HunterId 는 영어 소문자로 시작하며 20자를 넘지 않고 영소문자,대문자,숫자로만 이루어져야한다.
    // TODO (2) hunterPw 는 20자를 넘지 않아야한다. 비크립트로 암호화 필요.
    // TODO (3) hunterName은 15자를 넘으면 안된다.
    // TODO (4) hunterPictureName의 확장자는 그림 확장자만 가능 하게 해야 하고 유니크값으로 변환시켜야한다.
    // TODO (5) hunterPoint의 최대값은 99999점이고 증가 최대치는 100점이다.

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
