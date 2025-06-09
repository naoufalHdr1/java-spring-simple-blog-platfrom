package com.example.blogapp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombork.data;

@Entity
@Table(name = "comments");
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post; 

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
