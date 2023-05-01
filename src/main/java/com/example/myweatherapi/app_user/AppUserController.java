package com.example.myweatherapi.app_user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/admin/user-role-history")
    List<UserRolesHistoryView> getUserRoleHistoryByEmail(@RequestParam String userMail){
        return appUserService.getUserRolesHistoryByEmail(userMail);
    }

    @GetMapping("/admin/all-users-roles-history")
    List<UserRolesHistoryView> getAllUsersRolesHistory(){
        return appUserService.getUsersRolesHistory();
    }
}
