package io.github.wotjd243.findbyhint.hint.domain;

import java.util.Objects;

public class HintId {
    private int number;

    public HintId(final int number) {
        this.number = number;
    }

    public static HintId valueOf(final int number) {
        return new HintId(number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final HintId that = (HintId) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}

