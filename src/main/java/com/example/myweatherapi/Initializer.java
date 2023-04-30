package com.example.myweatherapi;

import com.example.myweatherapi.app_user.AppUser;
import com.example.myweatherapi.app_user.AppUserRepository;
import com.example.myweatherapi.app_user.Role;
import com.example.myweatherapi.app_user.RoleRepository;
import com.example.myweatherapi.security.EncryptionConfiguration;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class Initializer {

    private final RoleRepository roleRepository;
    private final AppUserRepository appUserRepository;
    private final EncryptionConfiguration encryptionConfiguration;

    @PostConstruct
    public void run() {

        Role user = roleRepository.save(new Role("USER"));
        Role admin = roleRepository.save(new Role("ADMIN"));

        String pass = encryptionConfiguration.passwordEncoder().encode("pass");
        AppUser user1 = appUserRepository.save(new AppUser("pioter", "pioter", "pioter@test.com", pass, List.of(user)));

    }
}
