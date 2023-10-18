package com.example.prak5.service;

import com.example.prak5.JwtTokenUtils;
import com.example.prak5.dto.AuthRequest;
import com.example.prak5.dto.JwtResponse;
import com.example.prak5.dto.RegistrationUserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Data
@RequiredArgsConstructor
public class TokenService {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenUtils jwtTokenUtils;
    public ResponseEntity<?> createToken( AuthRequest authRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception e) {
            System.out.println("Аутентификация зафейлилась");
           }
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }
//    public ResponseEntity<?> createNewUser( RegistrationUserDto registrationUserDto) {
////        if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
////            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пароли не совпадают"), HttpStatus.BAD_REQUEST);
////        }
////        if (userService.findByUsername(registrationUserDto.getUsername()).isPresent()) {
////            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
////        }
//        Cli user = userService.createNewUser(registrationUserDto);
//        return ResponseEntity.ok(new UserDto(user.getId(), user.getUsername(), user.getEmail()));
//    }
}
