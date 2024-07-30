package org.example.dao;

import org.example.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> user = getUserById(id);
        user.ifPresent(user1 -> entityManager.remove(user1));
    }

    @Override
    public Optional<User> getUserById(Long id) {
       User user = entityManager.find(User.class, id);
       return Optional.ofNullable(user);
    }
}
