package ru.kata.spring.boot_security.pp_3_1_2__3.dao;

import ru.kata.spring.boot_security.pp_3_1_2__3.entity.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();
    Role getRoleById(Integer id);
    Role getRoleByName(String name);
    void saveRole(Role role);
}


