package com.example.blogapp.service.interfaces;

import com.example.blogapp.dto.LoginRequestDTO;
import com.example.blogapp.dto.LoginResponseDTO;
import com.example.blogapp.dto.UserDTO;
import com.example.blogapp.dto.UserSignupDTO;

public interface AuthService {
    UserDTO register(UserSignupDTO dto);
    LoginResponseDTO login(LoginRequestDTO dto);
}
