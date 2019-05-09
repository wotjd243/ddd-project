package io.github.wotjd243.aladin.user.infra;

import io.github.wotjd243.aladin.user.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DummyUserData {

    private static final Map<String, User> userGroup = new HashMap<>();

    public static User put(User user) {
        return userGroup.put(user.getLoginId(), user);
    }


    public static Optional<User> get(String loginId) {
        return Optional.of(userGroup.get(loginId));
    }

}
