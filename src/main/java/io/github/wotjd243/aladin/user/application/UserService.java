package io.github.wotjd243.aladin.user.application;

import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.user.domain.User;
import io.github.wotjd243.aladin.user.domain.UserRepository;
import io.github.wotjd243.aladin.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserRequestDto requestDto) {
        User user = requestDto.toEntity();
        return userRepository.save(user);
    }

    public User findUserByLoginId(String loginId) {
        return userRepository.findUserByLoginId(loginId)
                .orElseThrow(() -> new NotFoundException("존재하지 않는 사용자 입니다."));
    }

}
