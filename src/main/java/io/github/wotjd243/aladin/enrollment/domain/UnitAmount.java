package io.github.wotjd243.aladin.enrollment.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.exception.WrongValueException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UnitAmount {

    private long amount;

    public UnitAmount(Long amount) {

        this.amount = validation(amount);
    }

    private Long validation(Long amount) {

        if (ObjectUtils.isEmpty(amount)) {
            throw new NotFoundException("금액이 없습니다.");
        }

        if (amount < 0) {
            throw new WrongValueException(String.format("금액 0보다 커야합니다. [%s]", amount));
        }

        return amount;
    }
}
