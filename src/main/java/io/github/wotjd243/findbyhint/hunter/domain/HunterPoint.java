package io.github.wotjd243.findbyhint.hunter.domain;

import io.github.wotjd243.findbyhint.util.check.Check;

public class HunterPoint {

    private int hunterPoint;

    public HunterPoint(int hunterPoint) {

        validation(hunterPoint);

        this.hunterPoint = hunterPoint;

    }

    private void validation(int hunterPoint) {

        Check.numberLimit(hunterPoint,99999);

    }


}
