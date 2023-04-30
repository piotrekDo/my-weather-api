package com.example.myweatherapi.app_user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResetPasswordDTO {
    private String mail;
    private String token;
    private String newPassword;
}
