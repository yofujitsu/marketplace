package com.example.prak5.controllers;

import com.example.prak5.entity.Book;
import com.example.prak5.entity.Cart;
import com.example.prak5.repository.RoleRepository;
import com.example.prak5.service.BookService;
import com.example.prak5.service.CartService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
//@RequestMapping("/book")
//@CrossOrigin("*")
public class CartControllers {
    private CartService cartService;

    @GetMapping("/showCart")
    public List get(){
        System.out.println(cartService.getAll().get(0));

        return cartService.getAll();
    }
    @PostMapping("/createCart")
    public void create(){
        Cart cart = new Cart();
        cartService.create(cart);
    }
    @PostMapping("/addToCart")
    public void add(Long Id, Long bookId){
        System.out.println(Id+" "+bookId);
        cartService.add(Id,bookId);
    }
    @DeleteMapping("/delete")
    public void delete(Long Id, Long bookId){
        System.out.println(Id+" "+bookId);
        cartService.delete(Id,bookId);
    }
    @PostMapping("/buyCart")
    public void delete(Long Id){
        System.out.println(Id+" ");
        cartService.buy(Id);
    }
}
