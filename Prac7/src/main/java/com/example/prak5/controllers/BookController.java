package com.example.prak5.controllers;

import com.example.prak5.entity.Book;
import com.example.prak5.repository.BookRepository;
import com.example.prak5.service.BookService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
//@RequestMapping("/book")
//@CrossOrigin("*")
//@Slf4j
public class BookController {
    BookService bookService;
    @GetMapping("/show")
    public List get(){
//        log.info("Отработал");
        System.out.println(bookService.getAll().get(0));


        return bookService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody Book book){
        System.out.println(book);
        bookService.save(book);
    }

}
