package io.github.wotjd243.ecommerce.user.infra;

import io.github.wotjd243.ecommerce.user.domain.User;
import io.github.wotjd243.ecommerce.user.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DummyUserRepository implements UserRepository {
    private final static String TEST_USER_ID = "TEST_USER";
    private final static String TEST_USER_ADDRESS = "서울시";

    private static List<User> users = new ArrayList<>();

    static {
        User user = new User(TEST_USER_ID, TEST_USER_ADDRESS);
        users.add(user);
    }

    public static String getTestUserId() {
        return TEST_USER_ID;
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        return users.stream().filter(v -> v.match(userId)).findFirst();
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}