package com.project.marketplaceservice.controller;
import com.project.marketplaceservice.dto.UserRequestDTO;
import com.project.marketplaceservice.dto.UserResponseDTO;
import com.project.marketplaceservice.entity.User;
import com.project.marketplaceservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService=userService;
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody UserRequestDTO requestDTO) {
        return userService.CreateUser(requestDTO);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable Long id) {
        return userService.getUserByEmail(id);
    }

}
