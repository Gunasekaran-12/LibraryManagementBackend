package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")

// @CrossOrigin(origins = "https://library-management-frontend1.vercel.app")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        
        // Add your login logic here
        boolean isValid = userService.validateUser(email, password);
        
        if (isValid) {
            return ResponseEntity.ok(Map.of("success", true, "message", "Login successful"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Invalid credentials"));
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> userData) {
        String email = userData.get("email");
        String password = userData.get("password");
        
        // Add your registration logic here
        User user = userService.createUser(email, password);
        
        if (user != null) {
            return ResponseEntity.ok(Map.of("success", true, "message", "Registration successful"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Registration failed"));
        }
    }
    @GetMapping("/register")
public ResponseEntity<?> testRegister() {
    return ResponseEntity.ok("Register endpoint is working! Use POST with JSON body.");
}
}