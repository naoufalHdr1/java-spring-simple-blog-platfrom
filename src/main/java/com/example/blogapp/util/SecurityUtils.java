package com.example.blogapp.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;

public class SecurityUtils {

    public static String getCurrentUserEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (auth != null && auth.isAuthenticated()) ? auth.getName() : null;
    }

    public static boolean hasRole(String role) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) return false;

        return auth.getAuthorities().stream()
            .anyMatch(authz -> authz.getAuthority().equals("ROLE_" + role));
    }


    public static boolean isAdmin() {
        return hasRole("ADMIN");
    }

    public static boolean isAuthor() {
        return hasRole("AUTHOR");
    }
}
