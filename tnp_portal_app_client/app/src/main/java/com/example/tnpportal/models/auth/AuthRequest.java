package com.example.tnpportal.models.auth;

public class AuthRequest {
    private String emailId;
    private String password;

    public AuthRequest(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }
}
