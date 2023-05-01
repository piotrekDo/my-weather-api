package com.example.myweatherapi.auth;

import com.example.myweatherapi.app_user.*;
import com.example.myweatherapi.error.IllegalOperationException;
import com.example.myweatherapi.mailing.EmailComposer;
import com.example.myweatherapi.security.EncryptionConfiguration;
import com.example.myweatherapi.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AppUserRepository appUserRepository;
    private final AppUserService appUserService;
    private final EncryptionConfiguration encryptionConfiguration;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EmailComposer emailComposer;

    public AuthenticationResponse register(RegisterRequest request) {

        appUserRepository.findByEmail(request.getEmail()).ifPresent(user -> {
            throw new IllegalOperationException("Another user already exists with email address " + user.getEmail());
        });

        AppUser newAppUser = new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                encryptionConfiguration.passwordEncoder().encode(request.getPassword()),
                List.of(appUserService.getDefaultUserRole())
        );

        AppUser savedUser = appUserRepository.save(newAppUser);
        String token = jwtService.generateToken(new UserDetailsAdapter(savedUser));
        CompletableFuture.runAsync(() -> emailComposer.sendRegistrationMessage(request));

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
            throw new IllegalOperationException("Wrong Credentials");
        }


        AppUser appUser = appUserRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.generateToken(new UserDetailsAdapter(appUser));
//        appUser.setCurrentToken(encryptionConfiguration.passwordEncoder().encode(token));
//        appUserRepository.save(appUser);
        return new AuthenticationResponse(
                appUser.getFirstName(),
                appUserService.getUserRoleNames(appUser.getUserRoles()),
                token,
                jwtService.getLocalDateTimeTokenExpiration(token)
        );
    }
}
