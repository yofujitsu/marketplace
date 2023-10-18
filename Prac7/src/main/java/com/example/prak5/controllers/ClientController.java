package com.example.prak5.controllers;

import com.example.prak5.dto.ClientDto;
import com.example.prak5.entity.Book;
import com.example.prak5.entity.Client;
import com.example.prak5.entity.Role;
import com.example.prak5.repository.BookRepository;
import com.example.prak5.repository.ClientRepository;
import com.example.prak5.repository.RoleRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Data
@AllArgsConstructor
//@RequestMapping("/book")
//@CrossOrigin("*")
public class ClientController {
    ClientRepository clientRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    private RoleRepository roleRepository;
    @JsonIgnore
    @GetMapping("/cli/show")
    public List get(){
        return clientRepository.findAll();
    }
    @PostMapping("/cli/add")
    public void add(ClientDto clientDto){
        System.out.println(clientDto);
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setEmail(clientDto.getEmail());
        client.setLogin(clientDto.getLogin());
        client.setPassword(bCryptPasswordEncoder.encode(clientDto.getPassword()));
        clientRepository.save(client);
        Role role = new Role();
        role.setName("ROLE_USER");
        role.getClients().add(client);
        roleRepository.save(role);
//        client.getRoles().add(role);
    }
    @PostMapping("/admin")
    public void addAdmin(){
//        System.out.println(clientDto);
        Client client = new Client();
        client.setName("admin");
        client.setEmail("admin");
        client.setLogin("admin");
        client.setPassword(bCryptPasswordEncoder.encode("admin"));
        clientRepository.save(client);
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        role.getClients().add(client);
        roleRepository.save(role);
//        client.getRoles().add(role);
    }
    @PutMapping("/addAdmin")
    public void putAdmin(Long id){
        System.out.println(id);
//        Client client = new Client();
//        client.setName("admin");
//        client.setEmail("admin");
//        client.setLogin("admin");
//        client.setPassword(bCryptPasswordEncoder.encode("admin"));
//        clientRepository.save(client);
//        Role role = new Role();
//        role.setName("ROLE_ADMIN");
//        role.getClients().add(client);
//        roleRepository.save(role);
////        client.getRoles().add(role);
        Client client = clientRepository.findById(id).get();
        Role role = new Role();
        role.setName("ROLE_ADMIN");
//        roleRepository.save(role);
        role.getClients().add(client);
        roleRepository.save(role);
//        return ResponseEntity.ok(client);
    }
    @PutMapping("/addSeller")
    public void putSeller(Long id){
        System.out.println(id);
//        Client client = new Client();
//        client.setName("admin");
//        client.setEmail("admin");
//        client.setLogin("admin");
//        client.setPassword(bCryptPasswordEncoder.encode("admin"));
//        clientRepository.save(client);
//        Role role = new Role();
//        role.setName("ROLE_ADMIN");
//        role.getClients().add(client);
//        roleRepository.save(role);
////        client.getRoles().add(role);
        Client client = clientRepository.findById(id).get();
        Role role = new Role();
        role.setName("ROLE_SELLER");
//        roleRepository.save(role);
        role.getClients().add(client);
        roleRepository.save(role);
//        return ResponseEntity.ok(client);
    }
}
