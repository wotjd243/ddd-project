package io.github.wotjd243.shoppinggogo.user.domain;

import javax.xml.bind.ValidationException;
import java.util.regex.Pattern;

public class Phone {

    private String phoneNumber;
    private String phoneRegex  = "[0-9]{11}";
    public Phone(String phoneNumber) {
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validate(String phoneNumber){
        boolean validation = Pattern.matches(phoneRegex,phoneNumber);
        if(validation==false) try {
            throw new ValidationException("not match format");
        } catch (ValidationException e) {
            e.printStackTrace();
        }

    }
}
