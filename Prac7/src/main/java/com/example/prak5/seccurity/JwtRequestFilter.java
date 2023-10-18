package com.example.prak5.seccurity;

import com.example.prak5.JwtTokenUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {
    private final JwtTokenUtils jwtTokenUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {
        String authHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;
        System.out.println(authHeader);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            try {
                username = jwtTokenUtils.getUsername(jwt);
                System.out.println(username);
            } catch (Exception e) {
                System.out.println("Время жизни токена вышло");
                log.debug("Время жизни токена вышло");
//            } catch (Exception e) {
                log.debug("Подпись неправильная");
            }
        }
        System.out.println("До иф "+ SecurityContextHolder.getContext().getAuthentication());
        System.out.println(username);
//
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println("Зашел в иф");
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    jwtTokenUtils.getRoles(jwt).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
            );

            SecurityContextHolder.getContext().setAuthentication(token);
            System.out.println("Установили пользователя "+ SecurityContextHolder.getContext().getAuthentication());
//        filterChain.doFilter(request, response);
        }
        filterChain.doFilter(request, response);
    }
}