package io.github.wotjd243.aladin.user.infra;

import io.github.wotjd243.aladin.user.domain.User;
import io.github.wotjd243.aladin.user.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummyUserRepository implements UserRepository {

    @Override
    public Optional<User> findUserByLoginId(String loginId) {

        return DummyUserData.get(loginId);
    }

    @Override
    public User save(User user) {

        return DummyUserData.put(user);
    }
}
