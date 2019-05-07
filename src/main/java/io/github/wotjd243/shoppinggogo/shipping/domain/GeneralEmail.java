package io.github.wotjd243.shoppinggogo.shipping.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralEmail {
    public String email;

    private GeneralEmail(final String email) {
        validate(email);
        this.email = email;
    }

    private void validate(final String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);

        if( !m.matches() ) {
            throw new IllegalArgumentException();
        }
    }

    public static GeneralEmail valueOf(final String email) {
        return new GeneralEmail(email);
    }

}
