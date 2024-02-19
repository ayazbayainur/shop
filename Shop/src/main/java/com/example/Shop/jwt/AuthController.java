//package com.example.Shop.jwt;
//
//import com.example.Shop.models.User;
//import com.example.Shop.services.UserService;
//import com.example.Shop.services.impl.MyUserDetailsService;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//@Data
//public class AuthController {
////    @Autowired
//    private AuthenticationManager authenticationManager;
//
////    @Autowired
//    private UserService userService;
//
////    @Autowired
//    private MyUserDetailsService myUserDetailsService;
//
////    @Autowired
//    private JwtUtil jwtUtil;
//
//    private final AuthenticationService service;
//
//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody RegisterRequest request
//    ){
//        return ResponseEntity.ok(service.register(request));
//    }
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
//        return ResponseEntity.ok(service.authenticate(request));
//    }
//
//}
