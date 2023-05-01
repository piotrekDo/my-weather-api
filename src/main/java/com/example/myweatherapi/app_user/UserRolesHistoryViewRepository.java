package com.example.myweatherapi.app_user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesHistoryViewRepository extends JpaRepository<UserRolesHistoryView, Long> {

    List<UserRolesHistoryView> findAllByUserEmail(String userEmail);
}
