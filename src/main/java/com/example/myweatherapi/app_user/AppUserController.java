package com.example.myweatherapi.app_user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/request-reset-password")
    MessageDTO requestResetPassword(@RequestParam String mail) {
        return appUserService.requestPasswordReset(mail);
    }

    @PostMapping("/reset-password")
    MessageDTO resetPassword(@RequestBody ResetPasswordDTO request){
        return appUserService.resetUserPassword(request);
    }

    @PostMapping("/admin/promote")
    UserRoleChangeResponse promoteUser(@RequestBody UserRoleChangeRequest request) {
        return appUserService.promoteUser(request);
    }

    @PostMapping("/admin/revoke")
    UserRoleChangeResponse revokeUserRole(@RequestBody UserRoleChangeRequest request) {
        return appUserService.revokeUserRole(request);
    }
}
