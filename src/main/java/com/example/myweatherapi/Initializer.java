package com.example.myweatherapi;

import com.example.myweatherapi.app_user.AppUser;
import com.example.myweatherapi.app_user.AppUserRepository;
import com.example.myweatherapi.app_user.Role;
import com.example.myweatherapi.app_user.RoleRepository;
import com.example.myweatherapi.security.EncryptionConfiguration;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
@Profile("h2")
public class Initializer {

    private final RoleRepository roleRepository;
    private final AppUserRepository appUserRepository;
    private final EncryptionConfiguration encryptionConfiguration;

    @PostConstruct
    public void run() {
        System.out.println();
        System.out.println();
        System.out.println("               INIT DATABASE");
        System.out.println();
        System.out.println();
        Role user = roleRepository.save(new Role("USER"));
        Role moderator = roleRepository.save(new Role("MODERATOR"));
        Role admin = roleRepository.save(new Role("ADMIN"));

        String pass = encryptionConfiguration.passwordEncoder().encode("pass");
        AppUser user1 = appUserRepository.save(new AppUser("pioter", "pioter", "pioter@test.com", pass, new HashSet<>()));
        AppUser user2 = appUserRepository.save(new AppUser("Typical", "User", "typical@test.com", pass, new HashSet<>()));
        user1.getUserRoles().add(user);
        user1.getUserRoles().add(moderator);
        user1.getUserRoles().add(admin);
        appUserRepository.save(user1);
        user2.getUserRoles().add(user);
        appUserRepository.save(user2);
    }
}
