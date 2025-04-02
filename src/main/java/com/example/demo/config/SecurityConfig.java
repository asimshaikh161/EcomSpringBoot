package com.example.demo.config;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            
            .csrf().disable()
           
            .headers().frameOptions().disable()
            .and()
            // Configure URL authorization rules
            .authorizeHttpRequests(auth -> auth
                // Permit all access to H2 console
                .requestMatchers("/h2-console/**").permitAll()
                // Require ADMIN role for admin endpoints
                .requestMatchers("/admin/**").hasRole("ADMIN")
                // Allow both USER and ADMIN roles for user endpoints
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                // All other endpoints require authentication
                .anyRequest().authenticated()
            )
            .httpBasic()   
            .and()
            .formLogin()
            .and()
            .logout();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new CustomUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }
}
