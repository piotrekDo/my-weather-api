package com.example.myweatherapi.app_user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class AppUserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> userRoles;

    static AppUserDto toDto(AppUser appUser) {
        return new AppUserDto(
                appUser.getId(),
                appUser.getFirstName(),
                appUser.getLastName(),
                appUser.getEmail(),
                appUser.getUserRoles().stream()
                        .map(Role::getRoleName)
                        .toList()
        );
    }
}
