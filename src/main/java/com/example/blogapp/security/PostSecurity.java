package com.example.blogapp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.blogapp.repository.PostRepository;
import com.example.blogapp.util.SecurityUtils;

@Component("postSecurity")
@RequiredArgsConstructor
public class PostSecurity {

    private final PostRepository postRepository;

    public boolean isOwner(Long postId) {
        String email = SecurityUtils.getCurrentUserEmail();

        return postRepository.findById(postId)
            .map(post -> post.getAuthor().getEmail().equals(email))
            .orElse(false);
    }

    public boolean isOwnerAndAuthor(Long postId) {
        return isOwner(postId) && SecurityUtils.isAuthor();
    }
}
