package com.project.marketplaceservice.controller;
import com.project.marketplaceservice.dto.ApiResponse;
import com.project.marketplaceservice.dto.UserRequestDTO;
import com.project.marketplaceservice.dto.UserResponseDTO;
import com.project.marketplaceservice.entity.User;
import com.project.marketplaceservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService=userService;
    }

    @PostMapping("/createuser")
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody UserRequestDTO requestDTO) {
        User created = userService.CreateUser(requestDTO);
        if (created != null) {
            return ResponseEntity.ok(ApiResponse.success(created));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error("Unable to create user", HttpStatus.BAD_REQUEST.value()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {

        UserResponseDTO userResponseDTO = userService.getUserByEmail(id);

        if(userResponseDTO != null)
        {
            return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}
