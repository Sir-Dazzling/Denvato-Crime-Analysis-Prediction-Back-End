package com.example.denvatocrimeanalyticsplatform.controllers;

import com.example.denvatocrimeanalyticsplatform.dao.JwtTokenRefreshRepository;
import com.example.denvatocrimeanalyticsplatform.dao.RoleRepository;
import com.example.denvatocrimeanalyticsplatform.dao.UserRepository;
import com.example.denvatocrimeanalyticsplatform.dao.VerificationTokenRepository;
import com.example.denvatocrimeanalyticsplatform.exceptions.BadRequestException;
import com.example.denvatocrimeanalyticsplatform.model.ERole;
import com.example.denvatocrimeanalyticsplatform.model.JwtRefreshToken;
import com.example.denvatocrimeanalyticsplatform.model.Role;
import com.example.denvatocrimeanalyticsplatform.model.User;
import com.example.denvatocrimeanalyticsplatform.payload.request.LoginRequest;
import com.example.denvatocrimeanalyticsplatform.payload.request.RefreshTokenRequest;
import com.example.denvatocrimeanalyticsplatform.payload.request.SignUpRequest;
import com.example.denvatocrimeanalyticsplatform.payload.response.JwtResponse;
import com.example.denvatocrimeanalyticsplatform.payload.response.MessageResponse;
import com.example.denvatocrimeanalyticsplatform.security.jwt.JwtUtils;
import com.example.denvatocrimeanalyticsplatform.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController
{
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    @Autowired
    JwtTokenRefreshRepository jwtTokenRefreshRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${app.jwtExpirationInMs}")
    private long jwtExpirationInMs;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String accessToken = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.ok(new JwtResponse(accessToken));
    }

    //Method to respond to sign up request and create user account
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest)
    {
        //Checking to see if username already exists.
        if (userRepository.existsByUsername(signUpRequest.getUsername()))
        {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        //Checking to see if Email already exists.
        if (userRepository.existsByEmail(signUpRequest.getEmail()))
        {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                passwordEncoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null)
        {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            System.out.println(userRole);
            roles.add(userRole);
        }
        else
            {
            strRoles.forEach(role ->
            {
                switch (role)
                {
                    case "admin" :
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "data_officer":
                        Role dataOfficerRole = roleRepository.findByName(ERole.ROLE_DATA_OFFICER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(dataOfficerRole);
                        break;
                    case "officer":
                        Role officerRole = roleRepository.findByName(ERole.ROLE_OFFICER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(officerRole);
                        break;
                    case "investigator":
                        Role investigatorRole = roleRepository.findByName(ERole.ROLE_INVESTIGATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(investigatorRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        user.setEnabled(false);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}