package io.github.wotjd243.findbyhint.util;

import java.util.Random;

public final class RandomUtils {
    private RandomUtils() {

    }
    public static int nextInt(final int to) {
        return new Random().nextInt(to) +1;
    }

}
