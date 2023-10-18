package com.example.prak5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WashingMachine  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String manufacturer;
    private int volume;
    private int numberSeller;
    private String type;
    private int price;
    private String title;
}
