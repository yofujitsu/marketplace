package com.example.prak5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.management.ConstructorParameters;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String author;
    private int numberAuthor;
    private String type;
    private int price;

    private String title;
    @ManyToMany
    @JsonIgnore
    private List<Cart> carts;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", numberAuthor=" + numberAuthor +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}
