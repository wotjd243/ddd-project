package io.github.wotjd243.aladin.book.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    private String category;

    public Category(String category) {

        this.category = validation(category);
    }

    private String validation(String category) {

        if (StringUtils.isEmpty(category)) {
            throw new NotFoundException("카테고리가 없습니다.");
        }

        return category;
    }
}
