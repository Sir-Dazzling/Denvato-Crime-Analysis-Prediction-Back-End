package com.example.denvatocrimeanalyticsplatform.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController
{
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
}
