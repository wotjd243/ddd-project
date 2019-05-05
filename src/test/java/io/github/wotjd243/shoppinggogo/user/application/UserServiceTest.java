package io.github.wotjd243.shoppinggogo.user.application;

import io.github.wotjd243.shoppinggogo.user.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void 유저_찾기_테스트(){
        Optional<User> user = userRepository.findById(1L);

    }
    @Test
    public void 회원가입했는지확인(){
        Boolean isSignIn = userService.isSingInUser(10L);
    }

}