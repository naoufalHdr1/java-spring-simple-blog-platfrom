package com.example.blogapp.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private Long id;
    private String text;
    private String username;
    private Long postId;
    private LocalDateTime createdAt;
}

