package io.github.wotjd243.shoppinggogo.user.ui;

import io.github.wotjd243.shoppinggogo.user.application.UserService;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}/loggedin")
    public Boolean isUserLogIn(@PathVariable Long id){
        return userService.isUserLoggedIn(id);
    }

    @GetMapping("/user/{id}")
    public User getUserInfo(@PathVariable Long id){
        return userService.getUser(id);
    }

}
