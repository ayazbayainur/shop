package com.example.Shop.services;

import com.example.Shop.dto.UserDto;
import com.example.Shop.models.User;
import com.example.Shop.models.enums.UserStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    void addUser(User user);
    User getUserByEmail(String email);
    List<User> getAllUsers();

    List<UserDto> findAllUsers();
    User updateUserEmail(User user, String email);
    User updateUserPassword(User user, String password);
    User updateUserStatus(User user, UserStatus status);
}
