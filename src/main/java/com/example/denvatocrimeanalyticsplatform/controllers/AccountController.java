package com.example.denvatocrimeanalyticsplatform.controllers;


import com.example.denvatocrimeanalyticsplatform.dao.UserRepository;

import com.example.denvatocrimeanalyticsplatform.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class AccountController
{
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user_dashboard")
    @PreAuthorize("hasRole('USER') or hasRole('CONTENT_MANAGER') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Dashboard.";
    }

    @GetMapping("/content_manager")
    @PreAuthorize("hasRole('CONTENT_MANAGER') or hasRole('ADMIN')")
    public String moderatorAccess() {
        return "Content Manager Board";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess()
    {
        return "Admin Board.";
    }

    @GetMapping("/admin_hub")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAdminHub()
    {
        return ResponseEntity.ok("Access Granted");
    }

    @GetMapping("/user")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getUserProfile(Authentication authentication)
    {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(userDetails);
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUsers()
    {
        List users = userRepository.findAll();

        return ResponseEntity.ok(users);
    }
}
