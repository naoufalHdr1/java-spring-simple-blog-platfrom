package com.example.blogapp.mapper;

import com.example.blog.dto.CommentCreateDTO;
import com.example.blog.dto.CommentDTO;
import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;

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
