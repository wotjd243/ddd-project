package io.github.wotjd243.aladin.common.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.exception.WrongValueException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {

    private final static String EMAIL_PATTERN = "^(.+)@(.+)$";

    private String email;

    public Email(String email) {

        this.email = validation(email);
    }

    private String validation(String email) {

        if (StringUtils.isEmpty(email)) {
            throw new NotFoundException("이메일이 없습니다.");
        }

        if (!Pattern.matches(EMAIL_PATTERN, email)) {
            throw new WrongValueException(String.format("이메일이 잘못되었습니다. [xxx@xxxx.com] [%s]", email));
        }

        return email;
    }
}
