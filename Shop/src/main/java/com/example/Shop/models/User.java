package com.example.Shop.models;


import com.example.Shop.models.enums.Role;
import com.example.Shop.models.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column(name = "telephone_number")
    private String telephonenumber;
    @Column
    @NonNull
    private String email;
    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column
    @NonNull
    private String username;
    @Column
    @NonNull
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
