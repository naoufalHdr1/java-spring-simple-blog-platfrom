package com.example.blogapp.service.interfaces;

import com.example.blogapp.dto.UserDTO;

public interface UserService {
    UserDTO getUserByUsername(String username);
    boolean existsByEmail(String email);
}
