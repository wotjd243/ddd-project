package io.github.wotjd243.aladin.common;

import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.exception.WrongValueException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PhoneNumber {

    private final static String PHONE_NUMBER_PATTERN = "^01(?:0|1|[6-9])-\\d{3,4}-\\d{4}$";

    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {

        this.phoneNumber = validation(phoneNumber);
    }

    private String validation(String phoneNumber) {

        if (StringUtils.isEmpty(phoneNumber)) {
            throw new NotFoundException("전화번호가 없습니다.");
        }

        if (!Pattern.matches(PHONE_NUMBER_PATTERN, phoneNumber)) {
            throw new WrongValueException(String.format("전화번호가 잘못되었습니다. [01x-xxx[x]-xxxx] [%s]", phoneNumber));
        }

        return phoneNumber;
    }
}
