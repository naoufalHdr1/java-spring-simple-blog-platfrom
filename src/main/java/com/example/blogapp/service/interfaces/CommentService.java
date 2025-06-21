package com.example.blogapp.service;

import com.example.blogapp.entity.Comment;
import com.example.blogapp.entity.Post;
import com.example.blogapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment saveComment(Comment comment);
    Optional<Comment> getCommentById(Long id);
    List<Comment> getCommentsByPost(Post post);
    List<Comment> getCommentsByUser(User user);
    void deleteComment(Long id);
}
