package io.github.wotjd243.shoppinggogo.user.domain;

import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Getter
public class Phone {

    private String phoneNumber;
    final static private String phoneRegex = "[0-9]{11}";
    final static private Pattern p = Pattern.compile(phoneRegex);

    public Phone(String phoneNumber) {
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validate(String phoneNumber) {
        Matcher m = p.matcher(phoneNumber);
        boolean validation = m.matches();
        if (validation == false) throw new IllegalArgumentException();

    }
}
