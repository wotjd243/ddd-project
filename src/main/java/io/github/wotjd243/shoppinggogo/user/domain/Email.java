package io.github.wotjd243.shoppinggogo.user.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Email {
    //email 생성시에 validation 지정
    private String email;
    final static private String emailPattern = "^[a-zA-z0-9]+@[a-zA-Z0-9]+.+[a-zA-Z]$";
    final Pattern pattern = Pattern.compile(emailPattern);

    public Email(String email) {
        validate(email);
        this.email = email;

    }
    public void validate(String email) {
        Matcher matcher = pattern.matcher(email);
        boolean emailValidation = matcher.matches();
        if(emailValidation==false) throw new IllegalArgumentException();
    }

}

