package io.github.wotjd243.ecommerce.user.application;

import io.github.wotjd243.ecommerce.user.application.dto.UserRequestDto;
import io.github.wotjd243.ecommerce.user.application.dto.UserResponseDto;
import io.github.wotjd243.ecommerce.user.domain.User;
import io.github.wotjd243.ecommerce.user.domain.UserRepository;
import io.github.wotjd243.ecommerce.user.domain.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto register(UserRequestDto dto) {
        if (isExists(dto.getUserId())) {
            throw new IllegalArgumentException("이미 등록된 계정입니다.");
        }

        User user = new User(dto.getUserId(), dto.getAddress());
        return userRepository.save(user).toDto();
    }

    public boolean isExists(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }

    public void checkValid(String userId) {
        if (!isExists(userId)) {
            throw new ResourceNotFoundException("현재 접속한 계정은 유효하지 않습니다.");
        }
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(v -> v.toDto()).collect(Collectors.toList());
    }
}
