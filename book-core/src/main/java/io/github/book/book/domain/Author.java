package io.github.book.book.domain;

import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@EqualsAndHashCode
public class Author {
    private String authorName;
    private Integer authorAge;

    @Builder
    public Author(String authorName, Integer authorAge) {
        amendAuthorName(authorName);
        amendAuthorAge(authorAge);
    }

    public void amendAuthorName(String authorName) {
        if(StringUtils.isEmpty(authorName)) {
            throw new IllegalArgumentException("저자 이름은 필수 정보입니다.");
        }
        this.authorName = authorName;
    }

    public void amendAuthorAge(Integer authorAge) {
        if(StringUtils.isEmpty(authorAge)) {
            throw new IllegalArgumentException("저자 나이는 필수 정보입니다.");
        }
        this.authorAge = authorAge;
    }
}
