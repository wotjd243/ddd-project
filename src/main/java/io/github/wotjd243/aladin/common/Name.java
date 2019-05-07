package io.github.wotjd243.aladin.common;

import io.github.wotjd243.aladin.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Name {

    private String name;

    public Name(String name) {

        this.name = validation(name);
    }

    private String validation(String name) {

        if (StringUtils.isEmpty(name)) {
            throw new NotFoundException("이름이 없습니다.");
        }

        return name;
    }
}
