package com.example.myweatherapi.app_user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserRoleChangeRequest {
    private String user;
    private String role;
}
