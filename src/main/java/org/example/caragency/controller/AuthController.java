package org.example.caragency.controller;

import org.example.caragency.dto.AuthResponse;
import org.example.caragency.model.Manager;
import org.example.caragency.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());

        if (token != null) {
            // Get manager details from token
            Manager manager = authService.validateTokenAndGetManager(token);

            if (manager != null) {
                // Create response with full manager details
                AuthResponse response = new AuthResponse(
                        token,
                        manager.getUserName(),
                        manager.getManagerName(),
                        manager.getManagerEmail()
                );

                return ResponseEntity.ok(response);
            }
        }

        return ResponseEntity.badRequest().body("Invalid credentials");
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest request) {
        boolean success = authService.changePassword(request.getUsername(), request.getOldPassword(), request.getNewPassword());
        return success ? ResponseEntity.ok("Password updated successfully") : ResponseEntity.status(400).build();
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        authService.logout("sample");
        return ResponseEntity.ok("Logged out successfully");
    }

    // Request DTOs
    public static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class ChangePasswordRequest {
        private String username;
        private String oldPassword;
        private String newPassword;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getOldPassword() {
            return oldPassword;
        }

        public void setOldPassword(String oldPassword) {
            this.oldPassword = oldPassword;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }
}