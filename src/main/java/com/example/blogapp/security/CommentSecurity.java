package com.example.blogapp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.blogapp.repository.CommentRepository;
import com.example.blogapp.util.SecurityUtils;

@Component("commentSecurity")
@RequiredArgsConstructor
public class CommentSecurity {

    private final CommentRepository commentRepository;

    public boolean isOwner(Long commentId) {
        String email = SecurityUtils.getCurrentUserEmail();

        return commentRepository.findById(commentId)
            .map(comment -> comment.getUser().getEmail().equals(email))
            .orElse(false);
    }
}
