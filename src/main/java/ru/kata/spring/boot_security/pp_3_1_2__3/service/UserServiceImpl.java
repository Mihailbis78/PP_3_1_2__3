package ru.kata.spring.boot_security.pp_3_1_2__3.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.pp_3_1_2__3.dao.RoleDao;
import ru.kata.spring.boot_security.pp_3_1_2__3.dao.UserDao;
import ru.kata.spring.boot_security.pp_3_1_2__3.entity.Role;
import ru.kata.spring.boot_security.pp_3_1_2__3.entity.User;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUser();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws
            UsernameNotFoundException {
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found " + email);
        }
        return user;
    }

    @PostConstruct
    @Transactional
    public void createDefaultUsers() {

        if(roleDao.getRoleByName("ROLE_ADMIN") == null) {
            roleDao.saveRole(new Role("ROLE_ADMIN"));
        }
        if(roleDao.getRoleByName("ROLE_USER") == null) {
                roleDao.saveRole(new Role("ROLE_USER"));
        }

        Role adminRole = roleDao.getRoleByName("ROLE_ADMIN");
        Role userRole = roleDao.getRoleByName("ROLE_USER");

        if (userDao.getUserByEmail("admin@example.com") == null) {
            User admin = new User("Admin", "Adminov",
                    "admin@example.com", "admin", Set.of(adminRole));
            saveUser(admin);
        }

        if (userDao.getUserByEmail("user@example.com") == null) {
            User user = new User("User", "Userov",
                    "user@example.com", "user", Set.of(userRole));
            saveUser(user);
        }

    }
}


