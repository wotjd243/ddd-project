package io.github.wotjd243.findbyhint.hunter.domain;

import io.github.wotjd243.findbyhint.util.check.Check;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class HunterId {

    private String hunterId;

    Check check = new Check();

    public HunterId(final String hunterId){

        validation(hunterId);

        this.hunterId = hunterId;
    }

    private void validation(String hunterId){

        check.startEngCheck(hunterId);

        check.lengthLimit(hunterId, 20);

        check.idpwCheck(hunterId);
    }

}
