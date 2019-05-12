package io.github.wotjd243.shoppinggogo.user.application;

import io.github.wotjd243.shoppinggogo.user.domain.User;
import io.github.wotjd243.shoppinggogo.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(final Long id){
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(IllegalAccessError::new));
    }

    public boolean checkRegisteredUserById(final Long id){
        Optional<User> user = userRepository.findById(id);
        if( !user.isPresent()) {
            return false;
        }
        return true;
    }

    public boolean lossUserPoint(final Long userId, final int point) {
        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        user.changePoint(user.getPoint() - point);

        return userRepository.updateUserInfo(user);
    }



}
