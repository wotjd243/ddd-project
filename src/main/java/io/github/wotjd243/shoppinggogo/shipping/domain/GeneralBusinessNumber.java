package io.github.wotjd243.shoppinggogo.shipping.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralBusinessNumber {
    public String businessNum;

    private GeneralBusinessNumber(final String businessNum) {
        validate(businessNum);
        this.businessNum = businessNum;
    }

    private void validate(final String businessNum) {
        String ePattern = "^\\d{3}-\\d{2}-\\d{4}$";

        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(businessNum);

        if( !m.matches() ) {
            throw new IllegalArgumentException();
        }
    }

    public  static GeneralBusinessNumber valueOf(final String businessNum) {
        return new GeneralBusinessNumber(businessNum);
    }
}
