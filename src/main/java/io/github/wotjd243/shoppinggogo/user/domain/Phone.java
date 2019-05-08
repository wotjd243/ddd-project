package io.github.wotjd243.shoppinggogo.user.domain;

import lombok.Getter;

import javax.xml.bind.ValidationException;
import java.util.regex.Pattern;
@Getter
public class Phone {

    private String phoneNumber;
    private String phoneRegex  = "[0-9]{11}";
    public Phone(String phoneNumber) {
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validate(String phoneNumber){
        boolean validation = Pattern.matches(phoneRegex,phoneNumber);
        if( validation==false) throw new IllegalArgumentException();

    }
}
