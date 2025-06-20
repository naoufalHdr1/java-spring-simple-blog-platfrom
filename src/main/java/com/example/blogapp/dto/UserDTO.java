package com.example.blogapp.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsController
@AllArgsController
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private Set<Role> roles;
}
