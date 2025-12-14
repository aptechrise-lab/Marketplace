package com.project.marketplaceservice.controller;
import com.project.marketplaceservice.entity.User;
import com.project.marketplaceservice.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService=userService;
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user) {
        return userService.CreateUser(user);
    }

}
