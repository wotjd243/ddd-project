package io.github.wotjd243.ecommerce.user.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

public class ZipCode {
    private final String code;

    private ZipCode(String code) {
        if (isInvalid(code)) {
            throw new IllegalArgumentException();
        }
        this.code = code;
    }

    public static ZipCode codeOf(String code) {
        return new ZipCode(code);
    }

    private boolean isInvalid(String code) {
        if (StringUtils.isBlank(code)) {
            return true;
        }
        if (!PatternEnum.POSTALCODE.toPattern()
                .matcher(code)
                .find()
        ) {
            return true;
        }
        return false;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode = (ZipCode) o;
        return Objects.equals(code, zipCode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    public enum PatternEnum {

        POSTALCODE("\\d{5}");

        private final String regex;

        private PatternEnum(final String regex) {
            this.regex = regex;
        }

        public Pattern toPattern() {
            return Pattern.compile(regex);
        }
    }
}
