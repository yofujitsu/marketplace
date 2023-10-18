package com.example.prak5.repository;

import com.example.prak5.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client,Long> {
    public Client findByName(String name);
}
