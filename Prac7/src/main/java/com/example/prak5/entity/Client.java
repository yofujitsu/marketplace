package com.example.prak5.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String login;
    private String password;
    @ManyToMany(mappedBy = "clients")
    private List<Role> roles = new ArrayList<>();
}
