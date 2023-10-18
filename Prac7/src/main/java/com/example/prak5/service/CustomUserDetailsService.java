package com.example.prak5.service;

import com.example.prak5.entity.Client;
import com.example.prak5.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private ClientRepository clientRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Client client= clientRepository.findByName(username);
        return new org.springframework.security.core.userdetails.User(
                client.getName(),
                client.getPassword(),
                client.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }
}
