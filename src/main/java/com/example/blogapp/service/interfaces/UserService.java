package com.example.blogapp.service;

import com.example.blogapp.dtp.UserDTO;

public interface UserService {
    UserDTO getUserByUsername(String username);
    boolean existsByEmail(String email);
}
