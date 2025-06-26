package com.example.blogapp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import com.example.blogapp.repository.PostRepository;

@Component("postSecurity")
@RequiredArgsConstructor
public class PostSecurity {

    private final PostRepository postRepository;

    public boolean isOwner(Long postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        return postRepository.findById(postId)
            .map(post -> post.getAuthor().getEmail().equals(email))
            .orElse(false);
    }
}
