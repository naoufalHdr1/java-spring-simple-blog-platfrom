package com.example.blogapp.service.impl;

import com.example.blogapp.dto.*;
import com.example.blogapp.entity.Role;
import com.example.blogapp.entity.User;
import com.example.blogapp.exception.DuplicateResourceException;
import com.example.blogapp.repository.RoleRepository;
import com.example.blogapp.repository.UserRepository;
import com.example.blogapp.security.JwtService;
import com.example.blogapp.service.interfaces.AuthService;
import com.example.blogapp.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public UserDTO register(UserSignupDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateResourceException("Email is already in use");
        }

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new DuplicateResourceException("Username is already taken");
        }

        Role defaultRole = roleRepository.findByName("READER")
                .orElseThrow(() -> new RuntimeException("Default role not found"));

        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(Collections.singleton(defaultRole))
                .build();

        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(userDetails);

        return LoginResponseDTO.builder()
                .token(jwtToken)
                .email(userDetails.getUsername())
                .roles(userDetails.getAuthorities().stream()
                        .map(auth -> auth.getAuthority())
                        .toList())
                .build();
    }
}
