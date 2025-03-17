package ru.kata.spring.boot_security.pp_3_1_2__3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.pp_3_1_2__3.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();
    User getUserById(Integer id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User getUserByEmail(String email);

}

