package ru.kata.spring.boot_security.pp_3_1_2__3.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.pp_3_1_2__3.entity.User;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<User> getAllUser() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public User getUserById(Integer id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = getUserById(id);
        if(user != null){
            em.remove(user);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u " +
                "WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }

}

