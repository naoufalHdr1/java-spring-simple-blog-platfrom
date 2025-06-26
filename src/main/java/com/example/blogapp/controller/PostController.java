package com.example.blogapp.controller;

import com.example.blogapp.dto.PostDTO;
import com.example.blogapp.dto.PostCreateDTO;
import com.example.blogapp.dto.PostUpdateDTO;
import com.example.blogapp.entity.Post;
import com.example.blogapp.service.interfaces.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> posts = postService.getAllPosts(); 

        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        PostDTO post = postService.getPostById(id);

        return ResponseEntity.ok(post);
    }

    @PreAuthorize("hasAnyRole('AUTHOR', 'ADMIN')")
    @PostMapping
    public ResponseEntity<PostDTO> createPost(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody PostCreateDTO dto
    ) {
        PostDTO post = postService.savePost(dto, userDetails.getUsername());

        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @PreAuthorize("hasRole('ADMIN') or @postSecurity.isOwnerAndAuthor(#id)")
    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(
            @PathVariable Long id,
            @RequestBody PostUpdateDTO dto
    ) {
        PostDTO post = postService.updatePost(id, dto);

        return ResponseEntity.ok(post);
    }

    @PreAuthorize("hasRole('ADMIN') or @postSecurity.isOwnerAndAuthor(#id)")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
