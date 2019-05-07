package io.github.wotjd243.shoppinggogo.shipping.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralPhoneNumber {

    public String phoneNumber;

    private GeneralPhoneNumber(final String phoneNumber) {
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validate(final String phoneNumber) {
        String ePattern = "^010-(\\d{3}|\\d{4})-\\d{4}$";

        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(phoneNumber);

        System.out.println(m.matches());
        if( !m.matches() ) {
            throw new IllegalArgumentException();
        }
    }

    public  static GeneralPhoneNumber valueOf(final String phoneNumber) {
        return new GeneralPhoneNumber(phoneNumber);
    }
}
