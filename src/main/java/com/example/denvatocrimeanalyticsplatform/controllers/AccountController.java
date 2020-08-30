package com.example.denvatocrimeanalyticsplatform.controllers;


import com.example.denvatocrimeanalyticsplatform.dao.UserRepository;

import com.example.denvatocrimeanalyticsplatform.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/account")
public class AccountController
{
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/public_crime_statistics")
    public ResponseEntity<?> getPublicCrimeStatistics()
    {
        return ResponseEntity.ok(new MessageResponse("Public Content"));
    }

    @GetMapping("/user_dashboard")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getUserDashboardAccess()
    {
        return ResponseEntity.ok(new MessageResponse("Access to User Dashboard Granted"));
    }

    @GetMapping("/data_officer_hub")
    @PreAuthorize("hasRole('DATA_OFFICER') or hasRole('ADMIN')")
    public ResponseEntity<?> getAccessToDataOfficerHub()
    {
        return ResponseEntity.ok(new MessageResponse("Access granted to Data Officer Hub"));
    }

    @GetMapping("/officer_hub")
    @PreAuthorize("hasRole('OFFICER') or hasRole('ADMIN')")
    public ResponseEntity<?> getAccessToOfficerHub()
    {
        return ResponseEntity.ok(new MessageResponse("Access granted to Officer Hub"));
    }

    @GetMapping("/investigator_hub")
    @PreAuthorize("hasRole('INVESTIGATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getAccessToInvestigatorHub()
    {
        return ResponseEntity.ok(new MessageResponse("Access granted to Investigator Hub"));
    }

    @GetMapping("/admin_hub")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAccessToAdminHub()
    {
        return ResponseEntity.ok(new MessageResponse("Access granted to Admin hub"));
    }

    //To get all user accounts
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUsers()
    {
        List users = userRepository.findAll();

        return ResponseEntity.ok(users);
    }
}
