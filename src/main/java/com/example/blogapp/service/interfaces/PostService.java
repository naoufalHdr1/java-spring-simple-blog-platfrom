package com.example.blogapp.service.interfaces;

import com.example.blogapp.entity.Post;
import com.example.blogapp.dto.PostDTO;
import com.example.blogapp.dto.PostCreateDTO;
import com.example.blogapp.dto.PostUpdateDTO;
import com.example.blogapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostDTO savePost(PostCreateDTO post, String email);
    PostDTO updatePost(Long id, PostUpdateDTO dto, String email);
    PostDTO getPostById(Long id);
    List<PostDTO> getAllPosts();
    List<Post> getPostsByUser(User user);
    List<Post> searchPostsByTitle(String keyword);
    void deletePost(Long id, String email);
}
