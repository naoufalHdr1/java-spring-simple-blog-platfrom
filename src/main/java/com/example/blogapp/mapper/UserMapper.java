package com.example.blogapp.mapper;

import com.example.blogapp.dto.UserDTO;
import com.example.blogapp.dto.UserSignupDTO;
import com.example.blogapp.entity.Role;
import com.example.blogapp.entity.User;

import java.util.stream.Collectors;
import java.util.Set;

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
                    .map(role -> role.getName().name())
                    .collect(Collectors.toSet()))
                .build();
    }
}

