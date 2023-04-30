package com.example.myweatherapi;

import com.example.myweatherapi.app_user.Role;
import com.example.myweatherapi.app_user.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Initializer {

    private final RoleRepository roleRepository;

    @PostConstruct
    public void run() {

        Role user = roleRepository.save(new Role("USER"));
        Role admin = roleRepository.save(new Role("ADMIN"));

    }
}
