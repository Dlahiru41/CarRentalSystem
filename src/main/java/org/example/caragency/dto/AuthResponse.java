package org.example.caragency.dto;

public class AuthResponse {
    private String token;
    private String userName;
    private String managerName;
    private String managerEmail;
    private String type = "Bearer";

    // Basic constructor with token only
    public AuthResponse(String token) {
        this.token = token;
    }

    // Full constructor
    public AuthResponse(String token, String userName, String managerName, String managerEmail) {
        this.token = token;
        this.userName = userName;
        this.managerName = managerName;
        this.managerEmail = managerEmail;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
