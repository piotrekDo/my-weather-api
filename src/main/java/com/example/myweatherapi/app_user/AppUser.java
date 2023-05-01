package com.example.myweatherapi.app_user;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_users")
@ToString
@EqualsAndHashCode
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Role> userRoles = new HashSet<>();
    private String currentToken;

    public AppUser(String firstName, String lastName, String email, String password, Set<Role> userRoles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRoles = userRoles;
    }
}
