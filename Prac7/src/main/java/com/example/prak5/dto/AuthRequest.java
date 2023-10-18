package com.example.prak5.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private  String username;
    private  String password;

    @Override
    public String toString() {
        return "AuthRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
