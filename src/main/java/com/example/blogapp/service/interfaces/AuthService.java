package com.example.blog.service.interfaces;

import com.example.blog.dto.LoginRequestDTO;
import com.example.blog.dto.LoginResponseDTO;
import com.example.blog.dto.UserDTO;
import com.example.blog.dto.UserSignupDTO;

public interface AuthService {
    UserDTO register(UserSignupDTO dto);
    LoginResponseDTO login(LoginRequestDTO dto);
}
