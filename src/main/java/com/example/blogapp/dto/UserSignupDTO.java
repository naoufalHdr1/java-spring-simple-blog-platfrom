package com.example.blogapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsController
@AllArgsController
@Builder
public class UserSignUpDTO {
    private String username;
    private String email;
    private String password;
}
~    
