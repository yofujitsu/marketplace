package com.example.prak5.controllers;

import com.example.prak5.entity.Client;
import com.example.prak5.entity.Telephone;
import com.example.prak5.repository.ClientRepository;
import com.example.prak5.repository.TelephoneRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class TelephoneController {
    TelephoneRepository telephoneRepository;
    @GetMapping("/tel/show")
    public List get(){
        return telephoneRepository.findAll();
    }
    @PostMapping("/tel/add")
    public void add(Telephone client){
        System.out.println(client);
        telephoneRepository.save(client);
    }
}
