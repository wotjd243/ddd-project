package io.github.wotjd243.findbyhint.hunter.domain;

import io.github.wotjd243.findbyhint.util.check.Check;
import org.springframework.beans.factory.annotation.Autowired;

public class HunterPoint {

    private int hunterPoint;

    Check check = new Check();

    public HunterPoint(int hunterPoint) {

        validation(hunterPoint);

        this.hunterPoint = hunterPoint;

    }

    private void validation(int hunterPoint) {

        check.numberLimit(hunterPoint,99999);

    }


}
