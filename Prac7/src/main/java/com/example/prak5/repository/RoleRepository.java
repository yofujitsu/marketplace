package com.example.prak5.repository;

import com.example.prak5.entity.Client;
import com.example.prak5.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
