package com.example.blogapp.repository;

import com.example.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Used in authentication logic to load users by username or email
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
