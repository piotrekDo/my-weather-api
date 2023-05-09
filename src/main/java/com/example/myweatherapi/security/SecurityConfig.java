package com.example.myweatherapi.security;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors(c -> {
            CorsConfigurationSource cs = request -> {
                CorsConfiguration cc = new CorsConfiguration();
                cc.setAllowedOrigins(List.of("http://localhost:5173/"));
                cc.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                cc.setAllowedHeaders(List.of("Origin", "Content-Type", "X-Auth-Token", "Access-Control-Expose-Header",
                        "Authorization"));
                cc.addExposedHeader("Authorization");
//                cc.addExposedHeader("User-Name");
                return cc;
            };
            c.configurationSource(cs);
        });
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);

        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(PathRequest.toH2Console()).permitAll()
        );
        http.authorizeHttpRequests().requestMatchers("/auth/**").permitAll();
        http.authorizeHttpRequests().requestMatchers("/user/admin/**").hasAuthority("ADMIN");
        http.authorizeHttpRequests().requestMatchers("/user/**").permitAll();
        http.authorizeHttpRequests().requestMatchers("/forecast/**").hasAuthority("USER");


        http.authorizeHttpRequests().anyRequest().authenticated();

        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}