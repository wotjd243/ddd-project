package io.github.wotjd243.aladin.user.ui;

import io.github.wotjd243.aladin.response.ApiResponse;
import io.github.wotjd243.aladin.user.application.UserService;
import io.github.wotjd243.aladin.user.domain.User;
import io.github.wotjd243.aladin.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/user/{loginId}")
    public ApiResponse<User> findUser(@PathVariable String loginId) {

        return ApiResponse.createOK(userService.findUserByLoginId(loginId));
    }

    @PostMapping(value = "/user")
    public ApiResponse<User> createUser(@RequestBody UserRequestDto request) {

        return ApiResponse.createOK(userService.createUser(request));
    }
}
