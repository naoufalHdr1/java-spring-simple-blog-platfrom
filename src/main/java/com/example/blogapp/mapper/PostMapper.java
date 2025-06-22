package com.example.blogapp.mapper;

import com.example.blogapp.dto.PostDTO;
import com.example.blogapp.dto.PostCreatedDTO;
import com.example.blogapp.entity.Post;
import com.example.blogapp.entity.User;

public class PostMapper {

    public static Post toEntity(PostCreatedDTO dto, User author) {
        return Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(author)
                .build();
    }

    public static PostDTO toDTO(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .authorUsername(post.getAuthor().getUsername())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
