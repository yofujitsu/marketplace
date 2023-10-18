package com.example.prak5.service;

import com.example.prak5.entity.Book;
import com.example.prak5.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;
    public List getAll(){
        return bookRepository.findAll();
    }
    public void save(Book book){
        bookRepository.save(book);
    }
}
