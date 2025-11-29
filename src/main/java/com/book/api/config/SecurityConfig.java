package com.book.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) //Turns off CSRF protection (Cross-Site Request
                // Forgery protection), which blocks POST requests without special tokens
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()//Allows ALL requests to ALL endpoints without authentication - no username/password needed
                );
        return http.build();
    }
}