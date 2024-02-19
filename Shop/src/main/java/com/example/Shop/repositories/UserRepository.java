package com.example.Shop.repositories;

import com.example.Shop.dto.UserDto;
import com.example.Shop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmail(String email);
    Optional<User> findUserByUsername(String username);
    User findUserByEmail(String email);
//    List<UserDto> findAllUsers();
}
