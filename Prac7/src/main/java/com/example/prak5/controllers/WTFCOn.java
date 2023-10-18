package com.example.prak5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WTFCOn {
    @GetMapping("/wtf")
    public String wtf(){
        return "wtf";
    }
}
