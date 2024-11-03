package org.example.caragency.controller;

import org.example.caragency.model.Manager;
import org.example.caragency.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @PostMapping("/users")
    public ResponseEntity<String> createNewUser(@RequestBody Manager manager) {
        managerService.createNewAccount(manager);
        return ResponseEntity.ok("User created successfully");
    }
}