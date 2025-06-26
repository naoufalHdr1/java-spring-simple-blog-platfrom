package com.example.blogapp.controller;

import com.example.blogapp.service.CommentService;
import com.example.blogapp.dto.CommentDTO;
import com.example.blogapp.dto.CommentCreateDTO;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDTO>> getCommentsByPost(@PathVariable Long postId) {
        List<CommentDTO> comments = commentService.getCommentsByPost(postId);

        return ResponseEntity.ok(comments);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> addCommentToPost(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long postId,
            @RequestBody CommentCreateDTO dto
    ) {
        CommentDTO createdComment = commentService.addComment(postId, dto, userDetails.getUsername());

        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @PreAuthorize("hasRole('ADMIN') or @commentSecurity.isOwner(#commentId)")
    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(
            @PathVariable Long commentId,
            @RequestBody CommentCreateDTO dto
    ) {
        CommentDTO updatedComment = commentService.updateComment(commentId, dto);

        return ResponseEntity.ok(updatedComment);
    }

    @PreAuthorize("hasRole('ADMIN') or @commentSecurity.isOwner(#commentId)")
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
