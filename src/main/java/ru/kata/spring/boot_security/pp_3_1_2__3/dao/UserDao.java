package ru.kata.spring.boot_security.pp_3_1_2__3.dao;

import ru.kata.spring.boot_security.pp_3_1_2__3.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUser();
    User getUserById(Integer id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);

    User getUserByEmail(String email);
}

