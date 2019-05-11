package io.github.wotjd243.ecommerce.user.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUserId(String userId);

    User save(User user);

    List<User> findAll();
}
