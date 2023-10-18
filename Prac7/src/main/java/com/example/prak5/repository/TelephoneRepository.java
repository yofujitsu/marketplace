package com.example.prak5.repository;

import com.example.prak5.entity.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository  extends JpaRepository<Telephone, Long> {
}
