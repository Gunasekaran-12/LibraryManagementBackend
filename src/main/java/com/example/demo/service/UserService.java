package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
  private final UserRepository repo;
  public UserService(UserRepository repo){ this.repo = repo; }

  public List<User> findAll(){ return repo.findAll(); }
  
  public User findOrThrow(Long id){
    return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
  }
  
  public User create(User u){ return repo.save(u); }
  
  // KEEP ONLY ONE UPDATE METHOD - This is the corrected one
  public User update(Long id, User updated){
    User u = findOrThrow(id);
    u.setName(updated.getName());
    u.setEmail(updated.getEmail());
    u.setContact(updated.getContact());
    u.setAddress(updated.getAddress());
    u.setUserType(updated.getUserType());
    if(updated.getPassword() != null) { 
        u.setPassword(updated.getPassword());
    }
    return repo.save(u);
  }
  
  public void delete(Long id){ repo.deleteById(id); }
  
  // Authentication methods
  public boolean validateUser(String email, String password) {
    User user = findByEmail(email);
    return user != null && user.getPassword().equals(password);
  }
  
  public User createUser(String email, String password) {
    User user = new User();
    user.setEmail(email);
    user.setPassword(password);
    return create(user);
  }
  
  public User findByEmail(String email) {
    return repo.findByEmail(email); // Fixed: changed 'repository' to 'repo'
  }
}