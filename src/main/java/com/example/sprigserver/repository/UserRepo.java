package com.example.sprigserver.repository;

import com.example.sprigserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
