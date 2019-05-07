package io.github.wotjd243.aladin.book.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Publisher {

    private String publisher;

    public Publisher(String publisher) {

        this.publisher = validation(publisher);
    }

    private String validation(String publisher) {

        if (StringUtils.isEmpty(publisher)) {
            throw new NotFoundException("출판사 정보가 없습니다.");
        }

        return publisher;
    }
}
