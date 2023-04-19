package com.example.myweatherapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("config");

        http.csrf().disable();
        http.cors().disable();
        http.headers().frameOptions().disable();

        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll()
//                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
}