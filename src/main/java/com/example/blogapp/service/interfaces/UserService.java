package com.example.blogapp.service.interfaces;

import com.example.blogapp.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO getUserByUsername(String username);
    UserDTO getUserByEmail(String email);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    boolean existsByEmail(String email);
}
