package org.example.caragency.model;

import jakarta.persistence.Entity;

@Entity
public class Manager extends User {
    private String managerName;
    private String managerEmail;

    // Getters and Setters
    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }
}