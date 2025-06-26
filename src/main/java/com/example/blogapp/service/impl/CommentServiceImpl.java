package com.example.blogapp.service.impl;

import com.example.blogapp.entity.Comment;
import com.example.blogapp.dto.CommentDTO;
import com.example.blogapp.dto.CommentCreateDTO;
import com.example.blogapp.mapper.CommentMapper;
import com.example.blogapp.entity.Post;
import com.example.blogapp.entity.User;
import com.example.blogapp.repository.CommentRepository;
import com.example.blogapp.repository.UserRepository;
import com.example.blogapp.repository.PostRepository;
import com.example.blogapp.service.CommentService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.blogapp.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public CommentDTO addComment(Long postId, CommentCreateDTO dto, String email) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Post not found with id: " + postId));
        User user = userRepository.findByEmail(email)
            .orElseThrow(() ->
                    new ResourceNotFoundException("User not found with email: " + email));

        Comment comment = CommentMapper.toEntity(dto, user, post);
        Comment savedComment = commentRepository.save(comment);

        return CommentMapper.toDTO(savedComment);
    }

    @Override
    public List<CommentDTO> getCommentsByPost(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);

        return comments.stream()
            .map(CommentMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public CommentDTO updateComment(Long commentId, CommentCreateDTO dto) {
        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Comment not found with id: " + commentId));

        comment.setText(dto.getText());
        Comment savedComment = commentRepository.save(comment);

        return CommentMapper.toDTO(savedComment);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Comment not found with id: " + commentId));
        commentRepository.delete(comment);
    }
}
