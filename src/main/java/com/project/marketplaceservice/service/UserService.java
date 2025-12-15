package com.project.marketplaceservice.service;
import com.project.marketplaceservice.dto.UserRequestDTO;
import com.project.marketplaceservice.dto.UserResponseDTO;
import com.project.marketplaceservice.entity.User;
import com.project.marketplaceservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository=userRepository;
    }


    public User CreateUser(UserRequestDTO request ){

        User attendee = new User();
        attendee.setName(request.getName());
        attendee.setEmail(request.getEmail());
        attendee.setPassword(request.getPassword());
        attendee.setRole(request.getRole());
        return userRepository.save(attendee);
    }

    public UserResponseDTO getUserByEmail(Long id) {
        User user = userRepository.findById(id).orElse(null);

        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setActive(user.getActive());

        return response;
    }


}
