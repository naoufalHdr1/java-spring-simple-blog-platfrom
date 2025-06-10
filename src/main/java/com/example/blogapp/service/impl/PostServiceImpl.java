package com.example.blogapp.service.impl;

import com.example.blogapp.entity.Post;
import com.example.blogapp.entity.User;
import com.example.blogapp.repository.PostRepository;
import com.example.blogapp.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getPostsByUser(User user) {
        return postRepository.findByAuthor(user);
    }

    @Override
    public List<Post> searchPostsByTitle(String keyword) {
        return postRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
