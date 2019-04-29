package io.github.wotjd243.aladin.enrollment.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.exception.WrongValueException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Count {

    private long count;

    public Count(Long count) {

        this.count = validation(count);
    }

    private Long validation(Long count) {

        if (ObjectUtils.isEmpty(count)) {
            throw new NotFoundException("권수가 없습니다.");
        }

        if (count < 0) {
            throw new WrongValueException(String.format("등록 권수는 0보다 커야합니다. [%s]", count));
        }

        return count;
    }
}
