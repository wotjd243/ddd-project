package io.github.wotjd243.shoppinggogo.user.infra;

import io.github.wotjd243.shoppinggogo.user.domain.User;
import io.github.wotjd243.shoppinggogo.user.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummyUserRepository implements UserRepository {
    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(DummyUserData.get(id));
    }

}
