package io.github.wotjd243.aladin.book.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Author {

    private String author;

    public Author(String author) {

        this.author = validation(author);
    }

    private String validation(String author) {

        if (StringUtils.isEmpty(author)) {
            throw new NotFoundException("저자정보가 없습니다.");
        }

        return author;
    }
}
