package com.example.myweatherapi.app_user;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final List<Role> appUserAvailableRoles;
//    private final Role defaultUserRole;

    public AppUserService(AppUserRepository appUserRepository, RoleRepository roleRepository) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
        this.appUserAvailableRoles = roleRepository.findAll();
//        this.defaultUserRole = appUserAvailableRoles.stream()
//                .filter(role -> role.getRoleName().equals("USER"))
//                .findFirst().orElseThrow(() -> new NoSuchElementException("No default user role found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(username)
                .orElseThrow(() -> new NoSuchElementException("No user found with email " + username));
        return new UserDetailsAdapter(appUser);
    }

    public AppUser loadAppUserByUsername(String username) {
       return appUserRepository.findByEmail(username)
               .orElseThrow(() -> new NoSuchElementException("No user found with email " + username));
    }

    public List<Role> getAvailableRoles() {
//        return this.appUserAvailableRoles;
        return roleRepository.findAll();
    }

    public Role getDefaultUserRole() {
//        return this.defaultUserRole;
        return roleRepository.findAll().stream()
                .filter(role -> role.getRoleName().equals("USER"))
                .findFirst().orElseThrow(() -> new NoSuchElementException("No default user role found"));
    }

    public String[] getUserRoleNames(Collection<Role> roles) {
       return roles.stream().map(Role::getRoleName).toArray(String[]::new);
    }
}
