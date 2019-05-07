package io.github.wotjd243.findbyhint.hint.infra;

import io.github.wotjd243.findbyhint.hint.domain.Hint;

import java.util.HashMap;
import java.util.Map;

public class DummyHintData {
    private static final Map<Integer, Hint> data = new HashMap<>();

    static {
        put(1,"브론즈","126.9941658","37.4954676");
        put(2,"실버","126.9941658","37.4954676");
        put(3,"골드","126.9941658","37.4954676");
        put(4,"플래티넘","126.9941658","37.4954676");
        put(5,"브론즈","126.9941658","37.4954676");
        put(6,"실버","126.9941658","37.4954676");
        put(7,"골드","126.9941658","37.4954676");
        put(8,"플래티넘","126.9941658","37.4954676");
    }

    public static Hint get(final int number) {
        return data.get(number);
    }

    private static Hint put(final int number, final String level, final String latitude, final String hardness) {
        return data.put(number, new Hint(number, level, latitude, hardness));
    }

}
