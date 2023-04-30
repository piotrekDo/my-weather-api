package com.example.myweatherapi.auth;

import com.example.myweatherapi.app_user.*;
import com.example.myweatherapi.security.EncryptionConfiguration;
import com.example.myweatherapi.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AppUserRepository appUserRepository;
    private final AppUserService appUserService;
    private final EncryptionConfiguration encryptionConfiguration;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {

        AppUser newAppUser = new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                encryptionConfiguration.passwordEncoder().encode(request.getPassword()),
                List.of(appUserService.getDefaultUserRole())
        );

        AppUser savedUser = appUserRepository.save(newAppUser);
        String token = jwtService.generateToken(new UserDetailsAdapter(savedUser));

        return new AuthenticationResponse(
                savedUser.getFirstName(),
                appUserService.getUserRoleNames(savedUser.getUserRoles()),
                token,
                jwtService.getLocalDateTimeTokenExpiration(token)
        );
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authenticate = null;
        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (Exception e) {
//            return AuthenticationResponse.builder().token(e.getLocalizedMessage()).build();
        }

        AppUser appUser = appUserRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.generateToken(new UserDetailsAdapter(appUser));
        return new AuthenticationResponse(
                appUser.getFirstName(),
                appUserService.getUserRoleNames(appUser.getUserRoles()),
                token,
                jwtService.getLocalDateTimeTokenExpiration(token)
        );
    }
}
