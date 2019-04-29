package io.github.wotjd243.findbyhint.hunter.domain;

import io.github.wotjd243.findbyhint.util.check.Check;
import org.springframework.beans.factory.annotation.Autowired;

public class HunterPw {

    private String hunterPw;

    Check check = new Check();

    public HunterPw(String hunterPw) {
        validation(hunterPw);
        this.hunterPw = hunterPw;
    }

    private void validation(String hunterPw){
        check.lengthLimit(hunterPw,20);
    }


}
