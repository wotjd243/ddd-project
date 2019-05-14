package io.github.wotjd243.shoppinggogo.user.domain;

import io.github.wotjd243.shoppinggogo.user.domain.User;

import java.util.Optional;

public interface UserRepository {

    public Optional<User> findById(Long id);
    boolean updateUserInfo(User user);
}
