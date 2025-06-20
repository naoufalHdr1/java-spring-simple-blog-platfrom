package com.example.blogapp.mapper;

import com.example.blog.dto.UserDTO;
import com.example.blog.dto.UserSignupDTO;
import com.example.blog.entity.Role;
import com.example.blog.entity.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static User toEntity(UserSignupDTO dto, Set<Role> roles, String encodedPassword) {
        return User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(encodedPassword)
                .roles(roles)
                .build();
    }

    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet()))
                .build();
    }
}

