package com.example.blogapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignupDTO {
    private String username;
    private String email;
    private String password;
}

