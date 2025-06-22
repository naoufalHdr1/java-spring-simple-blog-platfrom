package com.example.blogapp.mapper;

import com.example.blogapp.dto.CommentCreateDTO;
import com.example.blogapp.dto.CommentDTO;
import com.example.blogapp.entity.Comment;
import com.example.blogapp.entity.Post;
import com.example.blogapp.entity.User;

public class CommentMapper {

    public static Comment toEntity(CommentCreateDTO dto, User user, Post post) {
        return Comment.builder()
                .text(dto.getText())
                .user(user)
                .post(post)
                .build();
    }

    public static CommentDTO toDTO(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .text(comment.getText())
                .username(comment.getUser().getUsername())
                .postId(comment.getPost().getId())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
