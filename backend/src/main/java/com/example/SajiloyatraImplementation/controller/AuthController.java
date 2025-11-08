package com.example.SajiloyatraImplementation.controller;

import com.example.SajiloyatraImplementation.model.User;
import com.example.SajiloyatraImplementation.repository.UserRepository;
import com.example.SajiloyatraImplementation.service.JwtService; // Import the new service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication; // Import this
import org.springframework.security.core.context.SecurityContextHolder; // Import this
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000") // This is fine
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService; // 1. Inject the JwtService

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // --- THIS IS THE FIXED LOGIN METHOD ---
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        try {
            // 2. Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            // 3. Set authentication in security context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 4. Generate the token
            String token = jwtService.generateToken(authentication);

            // 5. Return the token as a plain string
            return ResponseEntity.ok(token);

        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}