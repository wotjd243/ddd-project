package io.github.wotjd243.shoppinggogo.user.domain;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(String id);

}
