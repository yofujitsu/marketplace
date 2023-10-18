package com.example.prak5.service;

import com.example.prak5.entity.Book;
import com.example.prak5.entity.Cart;
import com.example.prak5.repository.BookRepository;
import com.example.prak5.repository.CartRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class CartService {
    private CartRepository cartRepository;
    private BookRepository bookRepository;
    public List getAll(){
        return cartRepository.findAll();
    }
    public void create(Cart cart){
         cartRepository.save(cart);
    }
    @Transactional
    public void add(Long Id, Long bookId) {
//        cartRepository.save(cart);
        try{
            Cart cart = cartRepository.findById(Id).get();
            System.out.println(cart);
            Book book = bookRepository.findById(bookId).get();
            System.out.println(book);
            book.getCarts().add(cart);
            System.out.println(cart);
        }catch (NoSuchElementException e){
            System.out.println("Товара нет наличии");
        }
//        Cart cart = cartRepository.findById(Id).get();
//        if (cart!=null){
//            System.out.println(cart);
//            Book book = bookRepository.findById(bookId).get();
//            System.out.println(book);
//            book.getCarts().add(cart);
//            System.out.println(cart);
//        }
//        else{
//            System.out.println("Товара нет наличии");}
//        book.getCarts().add(cart.get());

    }

    @Transactional
    public void delete(Long Id, Long bookId) {
        Optional<Cart> cart = cartRepository.findById(Id);
        Book book = bookRepository.findById(bookId).get();
        System.out.println(book);
        book.getCarts().remove(cart.get());
    }
    @Transactional
    public void buy(Long Id) {
        Cart cart = cartRepository.findById(Id).get();
//        Book book = bookRepository.findById(bookId).get();
//        System.out.println(book);
        for (Book book:cart.getProductList()) {
            book.getCarts().remove(cart);
            bookRepository.delete(book);
        }

    }
}
