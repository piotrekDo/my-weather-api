package com.example.myweatherapi.security;

import com.example.myweatherapi.error.ResourceForbiddenException;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.AuthorizationEventPublisher;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthorizationEvents {

    private final AuthorizationEventPublisher authorizationEventPublisher;

    @EventListener
    public void onFailure(AuthorizationDeniedEvent failure) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
    }
}