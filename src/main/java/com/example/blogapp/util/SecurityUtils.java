package com.example.blogapp.util;

import com.example.blogapp.entity.User;
import com.example.blogapp.entity.RoleType;
import com.example.blogapp.entity.Post;

public class SecurityUtils {

    public static boolean isAdmin(User user) {
        return user.getRoles().stream()
            .anyMatch(role -> role.getName() == RoleType.ADMIN);
    }

    public static boolean isAuthor(User user) {
        return user.getRoles().stream()
            .anyMatch(role -> role.getName() == RoleType.AUTHOR);
    }

    public static boolean isOwner(User user, Post post) {
        return post.getAuthor().getId().equals(user.getId());
    }
}
