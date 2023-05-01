package com.example.myweatherapi;

import com.example.myweatherapi.app_user.AppUser;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Data
public class CustomContext {
    private AppUser appUser;
}
