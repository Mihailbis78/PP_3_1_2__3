package ru.kata.spring.boot_security.pp_3_1_2__3.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.pp_3_1_2__3.entity.Role;

import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return em.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    @Transactional
    public Role getRoleById(Integer id) {
        return em.find(Role.class, id);
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        List<Role> roles = em.createQuery("SELECT r FROM Role r WHERE r.name = :name"
        , Role.class)
                .setParameter("name", name)
                .getResultList();
        return roles.isEmpty() ? null : roles.get(0);
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        em.persist(role);
    }
}

