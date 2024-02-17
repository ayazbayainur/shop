package com.example.Shop.dto;


import com.example.Shop.models.enums.Role;
import com.example.Shop.models.enums.UserStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String telephonenumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
