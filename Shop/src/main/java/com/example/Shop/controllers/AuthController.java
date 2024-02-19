package com.example.Shop.controllers;

import com.example.Shop.dto.UserDto;
import com.example.Shop.jwt.AuthenticationRequest;
import com.example.Shop.jwt.AuthenticationService;
import com.example.Shop.jwt.RegisterRequest;
import com.example.Shop.models.User;
import com.example.Shop.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
@Data
public class AuthController {

//    @Autowired
    private UserService userService;
    private final AuthenticationService authenticationService;

    @GetMapping("/check")
    public String check(){
        return "just checking the endpoint";
    }

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
                               Model model,  @RequestBody RegisterRequest request){
        User existingUser = userService.getUserByEmail(userDto.getEmail());

//        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
//            result.rejectValue("email", null,
//                    "There is already an account registered with the same email");
//        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        authenticationService.register(request);
//        userService.addUser(mapToUser(userDto));
        return "redirect:/register?success";
    }

//    @GetMapping("/users")
//    public String users(Model model){
//        List<UserDto> users = userService.findAllUsers();
//        model.addAttribute("users", users);
//        return "users";
//    }

    @GetMapping("/login")
    public String login(@RequestBody AuthenticationRequest request){
        authenticationService.authenticate(request);
        return "login";
    }

}
