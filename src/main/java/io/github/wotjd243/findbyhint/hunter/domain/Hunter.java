package io.github.wotjd243.findbyhint.hunter.domain;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class Hunter {

    // TODO (1) 올바른 Exception 처리 관련 질문해서 반영하기.

    private final HunterId hunterId;

    private final HunterPw hunterPw;

    private final HunterName hunterName;

    private final String hunterPicturePath;

    private final HunterPictureName hunterPictureName;

    private final HunterPoint hunterPoint;

    private int hunterBullet;

    public Hunter(String hunterId, String hunterPw, String hunterName, String hunterPicturePath, String hunterPictureName, int hunterPoint, int hunterBullet) {
        this.hunterId = new HunterId(hunterId);
        this.hunterPw = new HunterPw(hunterPw);
        this.hunterName = new HunterName(hunterName);
        this.hunterPicturePath = hunterPicturePath;
        this.hunterPictureName = new HunterPictureName(hunterPictureName);
        this.hunterPoint = new HunterPoint(hunterPoint);
        this.hunterBullet = hunterBullet;
    }

    public void decreaseOneBullet() {

        int aa;

        if (hunterBullet < 1) {
            throw new IllegalStateException();
        }
        hunterBullet--;
    }

    public void increaseOneBullet() {
        if (hunterBullet >= 3) {
            log.println("이미 총알이 3개입니다.");
            throw new IllegalStateException();
        }
        hunterBullet++;
    }

    public void buyOneBullet() {

        log.println("before_hunterPoint : " + hunterPoint.getHunterPoint());
        log.println("before_hunterBullet : " + hunterBullet);

        if (hunterPoint.bulletBuyPointCheck()) {
            hunterPoint.hunterPointMinus(100);
            increaseOneBullet();
        } else {
            log.println("포인트가 부족합니다.");
            throw new IllegalStateException();
        }
        log.println("after_hunterPoint : " + hunterPoint.getHunterPoint());
        log.println("after_hunterBullet : " + hunterBullet);
    }

}
