package com.example.Shop.controllers;


import com.example.Shop.models.User;
import com.example.Shop.models.enums.UserStatus;
import com.example.Shop.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private UserServiceImpl userService;

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }


    @PostMapping("/add-user")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "User is saved.";
    }

    @GetMapping("/get-user/{email}")
    public String getUserByEmail(@PathVariable String email){
        userService.getUserByEmail(email);
        return "successful";
    }

    @PutMapping("/update-user-email/{email}")
    public User updateUserEmail(@RequestBody User user, @PathVariable String email){
        return userService.updateUserEmail(user, email);
    }

    @PutMapping("/update-user-password/{password}")
    public User updateUserPassword(@RequestBody User user, @PathVariable String password){
        return userService.updateUserPassword(user, password);
    }

    @PutMapping("/update-user-status/{status}")
    public User updateUserStatus(@RequestBody User user, @PathVariable UserStatus status){
        return userService.updateUserStatus(user, status);
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


}
