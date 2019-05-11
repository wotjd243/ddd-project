package io.github.wotjd243.findbyhint.hunter.domain;

import io.github.wotjd243.findbyhint.util.check.Check;

public class HunterPw {

    private String hunterPw;

    public HunterPw(String hunterPw) {
        validation(hunterPw);
        this.hunterPw = hunterPw;
    }

    private void validation(String hunterPw){
        Check.lengthLimit(hunterPw,20);
        Check.idpwCheck(hunterPw);
    }


}
