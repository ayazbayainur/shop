package com.example.Shop.controllers;

import com.example.Shop.dto.UserDto;
import com.example.Shop.models.User;
import com.example.Shop.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

//    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user  = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getTelephonenumber(),
                userDto.getEmail(),
                userDto.getRole(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getStatus()
        );
        return user;
    }

    @PostMapping("register/save")
    public String registration(@ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.getUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }
//        if(existingUser != null && existingUser.getUsername() != null && !existingUser.getUsername().isEmpty()){
//            result.rejectValue("username", null,
//                    "There is already an account registered with the same username");
//        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.addUser(mapToUser(userDto));
        return "redirect:/register?success";
    }

//    @GetMapping("/users")
//    public String users(Model model){
//        List<UserDto> users = userService.findAllUsers();
//        model.addAttribute("users", users);
//        return "users";
//    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
