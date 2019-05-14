package io.github.wotjd243.shoppinggogo.shipping.domain;

import java.util.regex.Pattern;

public class GeneralBusinessNumber {

    private final Pattern BUSINESS_NUMBER_PATTERN = Pattern.compile("^\\d{3}-\\d{2}-\\d{4}$");

    public String businessNum;

    private GeneralBusinessNumber(final String businessNum) {
        validate(businessNum);
        this.businessNum = businessNum;
    }

    private void validate(final String businessNum) {
       if( !BUSINESS_NUMBER_PATTERN.matcher(businessNum).matches() ) {
            throw new IllegalArgumentException();
        }
    }

    public  static GeneralBusinessNumber valueOf(final String businessNum) {
        return new GeneralBusinessNumber(businessNum);
    }
}
