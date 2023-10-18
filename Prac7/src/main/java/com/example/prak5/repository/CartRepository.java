package com.example.prak5.repository;

import com.example.prak5.entity.Book;
import com.example.prak5.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
