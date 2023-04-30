package com.example.myweatherapi.app_user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;
    @OneToOne(targetEntity = AppUser.class, fetch = FetchType.EAGER)
    private AppUser appUser;
    private LocalDateTime expiryDate;

    public PasswordResetToken() {
    }

    public PasswordResetToken(String token, AppUser appUser) {
        this.token = token;
        this.appUser = appUser;
        this.expiryDate = LocalDateTime.now().plusMinutes(30);
    }
}
