package com.example.blogapp.service;

import com.example.blogapp.entity.Comment;
import com.example.blogapp.dto.CommentDTO;
import com.example.blogapp.dto.CommentCreateDTO;
import com.example.blogapp.entity.Post;
import com.example.blogapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    CommentDTO addComment(Long postId, CommentCreateDTO dto, String email);
    List<CommentDTO> getCommentsByPost(Long postId);
    CommentDTO updateComment(Long commentId, CommentCreateDTO dto);
    void deleteComment(Long commentId);
}
