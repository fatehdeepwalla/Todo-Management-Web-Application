package org.example.security;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {
    InMemoryUserDetailsManager inMemoryUserDetailsManager;
    @Bean
    public InMemoryUserDetailsManager create() {
        UserDetails userDetails1 = getUserDetails("fateh", "fateh");
        UserDetails userDetails2 = getUserDetails("simran", "simran");
        UserDetails userDetails3 = getUserDetails("jasvinder", "jasvinder");
        UserDetails userDetails4 = getUserDetails("admin", "admin");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2, userDetails3, userDetails4);
    }

    private @NonNull UserDetails getUserDetails(String username, String password) {
        Function<String, String> encoder = input-> passwordEncoder().encode(input);
        UserDetails userDetails=User.builder()
                                    .passwordEncoder(encoder)
                                    .username(username)
                                    .password(password)
                                    .roles("USER","ADMIN")
                                    .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());

        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frameOptionsConfig-> frameOptionsConfig.disable()));

        return http.build();
    }
}
