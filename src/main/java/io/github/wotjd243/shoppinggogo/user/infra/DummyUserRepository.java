package io.github.wotjd243.shoppinggogo.user.infra;

import io.github.wotjd243.shoppinggogo.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummyUserRepository implements UserRepository {
    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(DummyUserData.get(id));
    }
}
