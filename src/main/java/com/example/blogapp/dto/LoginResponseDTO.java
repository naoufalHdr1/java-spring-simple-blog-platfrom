package com.example.blogapp.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsController
@AllArgsController
@Builder
public class LoginResponseDTO {
    private String token;
    private String username;
    private Set<Role> roles;
    private String expiresAt;
}

