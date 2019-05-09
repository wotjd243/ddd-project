package io.github.wotjd243.aladin.user.domain;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findUserByLoginId(String loginId);

    User save(User user);

}
