package io.github.wotjd243.aladin.utils;

import io.github.wotjd243.aladin.exception.TypeMissMatchException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongConvert {

    public static Long valueOf(String fieldName, String value) {

        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            throw new TypeMissMatchException(String.format("[%s] 타입은 Long 이여야합니다. 실제값 : %s", fieldName, value));
        }
    }
}
