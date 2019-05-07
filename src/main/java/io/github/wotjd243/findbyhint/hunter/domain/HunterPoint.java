package io.github.wotjd243.findbyhint.hunter.domain;

import io.github.wotjd243.findbyhint.util.check.Check;

public class HunterPoint {

    private int hunterPoint;

    public HunterPoint(int hunterPoint) {

        validation(hunterPoint);

        this.hunterPoint = hunterPoint;

    }

    private void validation(int hunterPoint) {

        Check.numberLimit(hunterPoint, 99999);

    }

    public boolean bulletBuyPointCheck() {
        if (hunterPoint > 100) {
            return true;
        } else {
            return false;
        }
    }

    public HunterPoint hunterPointMinus(int minus) {
        hunterPoint = hunterPoint - minus;
        return new HunterPoint(hunterPoint);
    }


    public HunterPoint hunterPointPlus(int plus) {
        hunterPoint = hunterPoint + plus;
        return new HunterPoint(hunterPoint);
    }

    public int getHunterPoint() {
        return hunterPoint;
    }
}
