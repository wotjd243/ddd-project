package io.github.wotjd243.shoppinggogo.payment.domain;

import java.math.BigInteger;
import java.util.Objects;

public class Amount {

    public static final int MINIMUM_NUMBER = 1;
    // 1억이상 결제 x
    public static final int MAXIMUM_NUMBER = 100000000;

    private int amount;

    private Amount(final int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < MINIMUM_NUMBER && amount > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Amount that = (Amount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }


    public  static Amount valueOf(final int amount) {
        return new Amount(amount);
    }
}
