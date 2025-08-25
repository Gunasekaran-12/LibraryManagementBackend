package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController 
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")  // Add this line
public class UserController {
  private final UserService service;
  public UserController(UserService s){ this.service = s; }

  @GetMapping 
  public List<User> all(){ return service.findAll(); }
  
  @PostMapping 
  public User create(@RequestBody User u){ return service.create(u); }
  
  @PutMapping("/{id}") 
  public User update(@PathVariable Long id, @RequestBody User u){ return service.update(id, u); }
  
  @DeleteMapping("/{id}") 
  public void delete(@PathVariable Long id){ service.delete(id); }
  
  // Add these new authentication endpoints
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
      String email = credentials.get("email");
      String password = credentials.get("password");
      
      boolean isValid = service.validateUser(email, password);
      
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
      
      User user = service.createUser(email, password);
      
      if (user != null) {
          return ResponseEntity.ok(Map.of("success", true, "message", "Registration successful"));
      } else {
          return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Registration failed"));
      }
  }
}