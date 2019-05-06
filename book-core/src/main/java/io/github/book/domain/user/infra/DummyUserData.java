package io.github.book.domain.user.infra;

import io.github.book.domain.user.domain.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DummyUserData {
    private static final Map<Long, User> data = new HashMap<>();

    static {
        put(1L, "자바지기", "test1@gmail.com", "1234", "000-0000-0000", LocalDate.now());
        put(1L, "산지기", "test2@gmail.com", "1234", "000-0000-0000", LocalDate.now());
        put(1L, "박문수", "test3@gmail.com", "1234", "000-0000-0000", LocalDate.now());
        put(1L, "트램", "test4@gmail.com", "1234", "000-0000-0000", LocalDate.now());
        put(1L, "씨유", "test5@gmail.com", "1234", "000-0000-0000", LocalDate.now());
        put(1L, "브라이언", "test6@gmail.com", "1234", "000-0000-0000", LocalDate.now());
        put(1L, "휴", "test7@gmail.com", "1234", "000-0000-0000", LocalDate.now());
    }

    public static User get(Long id) {
        return data.get(id);
    }

    private static User put(Long id, String name, String email, String password, String phoneNumber, LocalDate birthDay) {
        return data.put(id, new User(name, email, password, phoneNumber, birthDay));
    }
}
