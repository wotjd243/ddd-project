package io.github.wotjd243.shoppinggogo.user.infra;

import io.github.wotjd243.shoppinggogo.user.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);

}
