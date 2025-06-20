package com.example.blogapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsController
@AllArgsController
@Builder
public class LoginRequestDTO {
    private String email;
    private String password;
}
