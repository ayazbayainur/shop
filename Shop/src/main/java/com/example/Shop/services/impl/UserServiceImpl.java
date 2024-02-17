package com.example.Shop.services.impl;

import com.example.Shop.dto.UserDto;
import com.example.Shop.models.User;
import com.example.Shop.models.enums.UserStatus;
import com.example.Shop.repositories.UserRepository;
import com.example.Shop.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
//    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getTelephonenumber(),
                user.getEmail(),
                user.getRole(),
                user.getUsername(),
                user.getPassword(),
                user.getStatus()
        );
        return userDto;
    }

    public User updateUserEmail(User user, String email) {
        user.setEmail(email);
        return userRepository.save(user);
    }

    public User updateUserStatus(User user, UserStatus status) {
        user.setStatus(status);
        return userRepository.save(user);
    }

    public User updateUserPassword(User user, String password) {
        user.setPassword(password);
        return userRepository.save(user);
    }

}
