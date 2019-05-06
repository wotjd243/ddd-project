package io.github.wotjd243.shoppinggogo.user.domain;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.xml.bind.ValidationException;
import java.util.regex.Pattern;


public class Email {
    //email 생성시에 validation 지정
    private String email;
//    Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+$");
    private String emailPattern = "^[a-zA-z0-9]+@[a-zA-Z0-9]+.+[a-zA-Z]$";
    public Email(String email) {
        validate(email);
        this.email = email;

    }
    public void validate(String email) {
        boolean emailValidation = Pattern.matches(emailPattern,email);
        if(emailValidation==false) throw new IllegalArgumentException();
    }

}

