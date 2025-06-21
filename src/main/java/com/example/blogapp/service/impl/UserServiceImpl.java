package com.example.blogapp.service.impl;

import com.example.blogapp.dto.UserDTO;
import com.example.blogapp.entity.User;
import com.example.blogapp.repository.UserRepository;
import com.example.blogapp.mapper.UserMapper;
import com.example.blogapp.service.interfaces.UserService;
import com.example.blogapp.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() ->
                    new ResourceNotFoundException("User not found with username: " + username));

        return UserMapper.toDTO(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
