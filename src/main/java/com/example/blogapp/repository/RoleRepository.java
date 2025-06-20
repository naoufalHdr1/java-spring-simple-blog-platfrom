package com.example.blogapp.repository;

import com.example.blogapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Used to fetch roles when assigning them to users during registration or admin management.
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
