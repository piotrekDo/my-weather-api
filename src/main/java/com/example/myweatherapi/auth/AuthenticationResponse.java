package com.example.myweatherapi.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String firstName;
    private String[] roles;
    private String token;
    private LocalDateTime tokenExpiresAt;
}
