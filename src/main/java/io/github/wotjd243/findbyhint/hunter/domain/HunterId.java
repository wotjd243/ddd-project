package io.github.wotjd243.findbyhint.hunter.domain;

import io.github.wotjd243.findbyhint.util.check.Check;

public class HunterId {

    private String hunterId;

    public HunterId(final String hunterId) {

        validation(hunterId);

        this.hunterId = hunterId;
    }

    private void validation(String hunterId) {

        Check.startEngCheck(hunterId);

        Check.lengthLimit(hunterId, 20);

        Check.idpwCheck(hunterId);
    }

}
