package com.example.prak5.controllers;

import com.example.prak5.dto.AuthRequest;
import com.example.prak5.entity.Book;
import com.example.prak5.service.TokenService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
public class AuthController {
    private TokenService tokenService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        System.out.println(authRequest);
        return tokenService.createToken(authRequest);
    }

//    @PostMapping("/reg")
//    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
//        return tokenService.createNewUser(registrationUserDto)
//    }
}