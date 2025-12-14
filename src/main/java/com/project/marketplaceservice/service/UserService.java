package com.project.marketplaceservice.service;
import com.project.marketplaceservice.entity.User;
import com.project.marketplaceservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository=userRepository;
    }


    public User CreateUser(User user){
        return userRepository.save(user);
    }


}
