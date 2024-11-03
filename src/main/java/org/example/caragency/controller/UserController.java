package org.example.caragency.controller;

import org.example.caragency.model.User;
import org.example.caragency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        String token = userService.registerUser(user);
        return ResponseEntity.ok("JWT Token: " + token); // or use JSON format for API responses
    }

    // Add login endpoint similarly if required
}
