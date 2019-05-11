package io.github.wotjd243.findbyhint.hunter.domain;

import io.github.wotjd243.findbyhint.util.check.Check;

public class HunterName {

    private String hunterName;

    public HunterName(String hunterName) {
        validation(hunterName);
        this.hunterName = hunterName;
    }

    private void validation(String hunterName) {

        Check.lengthLimit(hunterName, 15);

    }
}
