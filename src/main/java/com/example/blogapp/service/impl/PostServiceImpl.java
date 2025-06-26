package com.example.blogapp.service.impl;

import com.example.blogapp.entity.Post;
import com.example.blogapp.entity.User;
import com.example.blogapp.dto.PostDTO;
import com.example.blogapp.dto.PostCreateDTO;
import com.example.blogapp.dto.PostUpdateDTO;
import com.example.blogapp.mapper.PostMapper;
import com.example.blogapp.entity.User;
import com.example.blogapp.repository.PostRepository;
import com.example.blogapp.repository.UserRepository;
import com.example.blogapp.service.interfaces.PostService;
import org.springframework.stereotype.Service;
import com.example.blogapp.exception.ResourceNotFoundException;
import com.example.blogapp.exception.AccessDeniedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public PostDTO savePost(PostCreateDTO dto, String email) {
        User author = userRepository.findByEmail(email)
            .orElseThrow(() ->
                    new ResourceNotFoundException("User not found with email: " + email));
        Post post = PostMapper.toEntity(dto, author);
        Post savedPost = postRepository.save(post);

        return PostMapper.toDTO(savedPost);
    }

    @Override
    public PostDTO updatePost(Long id, PostUpdateDTO dto) {
        Post post = postRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Post not found with id: " + id));

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());

        Post savedPost = postRepository.save(post);

        return PostMapper.toDTO(savedPost);
    }


    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Post not found with id " + id));

        return PostMapper.toDTO(post);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll()
            .stream()
            .map(PostMapper::toDTO)
            .collect(Collectors.toList());
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
        Post post = postRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Post not found with id: " + id));

        postRepository.deleteById(id);
    }
}
