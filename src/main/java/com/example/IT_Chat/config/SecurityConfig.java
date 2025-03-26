package com.example.IT_Chat.config;

import com.example.IT_Chat.repository.PersonRepository;
import com.example.IT_Chat.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()  // Zugriff auf die H2-Konsole erlauben
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**") // CSRF-Schutz für H2 deaktivieren
                )
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable) // FrameOptions deaktivieren für die H2-Konsole
                )
                .formLogin(withDefaults()); // Standard-Login-Formular aktivieren

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(PersonRepository personRepository) {
        return new CustomUserDetailService(personRepository);
    }
}

