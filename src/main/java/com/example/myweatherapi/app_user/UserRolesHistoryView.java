package com.example.myweatherapi.app_user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Entity
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "user_roles_history")
public class UserRolesHistoryView {
    @Id
    @Column(name = "record_id")
    private Long recordId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "email")
    private String userEmail;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "name")
    private String actionTaken;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime time;
}
