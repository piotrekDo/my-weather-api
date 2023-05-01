package com.example.myweatherapi.security;


import com.example.myweatherapi.CustomContext;
import com.example.myweatherapi.app_user.AppUser;
import com.example.myweatherapi.app_user.AppUserService;
import com.example.myweatherapi.app_user.UserDetailsAdapter;
import com.example.myweatherapi.error.ErrorEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final AppUserService appUserService;
    private final EncryptionConfiguration encoder;
    private final CustomContext customContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwt;
        String username;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7);

        try {
            username = jwtService.extractUsername(jwt);
        } catch (Exception e) {
            if (e instanceof SignatureException) System.err.println("SignatureException");
            ErrorEntity<String> tokenExpiredError = new ErrorEntity<>(
                    HttpStatus.FORBIDDEN.value(),
                    e.getClass().getSimpleName(),
                    e.getMessage());
            response.setContentType(APPLICATION_JSON_VALUE);
            response.getWriter().write(new ObjectMapper().writeValueAsString(tokenExpiredError));
            return;
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            AppUser appUser = appUserService.loadAppUserByUsername(username);
            UserDetailsAdapter userDetails = new UserDetailsAdapter(appUser);

//            boolean tokenMatches = encoder.passwordEncoder().matches(jwt, appUser.getCurrentToken());
//            System.err.println(tokenMatches);
//            if (!tokenMatches) {
//                System.out.println("Zly token");
//                return;
//            }


            if (jwtService.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
                customContext.setAppUser(appUser);
            }
        }
        filterChain.doFilter(request, response);
    }
}
