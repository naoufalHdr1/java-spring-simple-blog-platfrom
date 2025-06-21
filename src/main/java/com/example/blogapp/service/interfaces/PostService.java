package com.example.blogapp.service;

import com.example.blogapp.entity.Post;
import com.example.blogapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post savePost(Post post);
    Optional<Post> getPostById(Long id);
    List<Post> getAllPosts();
    List<Post> getPostsByUser(User user);
    List<Post> searchPostsByTitle(String keyword);
    void deletePost(Long id);
}
