package com.example.blogapp.repository;

import com.example.blogapp.entity.Post;
import com.example.blogapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(User author);
    List<Post> findByTitleContainingIgnoreCase(String title);
}
