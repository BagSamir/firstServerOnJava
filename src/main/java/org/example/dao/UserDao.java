package org.example.dao;

import org.example.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    Optional<User> getUserById(Long id);
}
