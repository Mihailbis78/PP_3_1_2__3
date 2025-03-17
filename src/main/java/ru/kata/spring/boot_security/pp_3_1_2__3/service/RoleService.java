package ru.kata.spring.boot_security.pp_3_1_2__3.service;

import ru.kata.spring.boot_security.pp_3_1_2__3.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Integer id);
    Role getRoleByName(String name);
    void saveRole(Role role);
}

