package com.example.myweatherapi.app_user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("admin/promote")
    UserRoleChangeResponse promoteUser(@RequestBody UserRoleChangeRequest request) {
        return appUserService.promoteUser(request);
    }

    @PostMapping("/admin/revoke")
    UserRoleChangeResponse revokeUserRole(@RequestBody UserRoleChangeRequest request) {
        return appUserService.revokeUserRole(request);
    }
}
