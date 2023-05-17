package ru.banki.mpk.javaweekly.springsecurityexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import ru.banki.mpk.javaweekly.springsecurityexample.model.Role;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder().username("bankiru")
                        .password(passwordEncoder().encode("bankiru"))
                        .authorities(Role.ADMIN.getAuthorities())
                        .build(),
                User.builder().username("user")
                        .password(passwordEncoder().encode("user"))
                        .authorities(Role.USER.getAuthorities())
                        .build()
        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

}
