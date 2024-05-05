package com.training.boot.security.bootsecuritybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                authorize -> authorize
                                .requestMatchers("private").authenticated()
                                .anyRequest().permitAll())
                            .logout().logoutUrl("/logout").logoutSuccessUrl("/").and()
                            .formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/").failureUrl("/login?error");
        return http.build();
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    UserDetailsService userDetailsService() {
      return new InMemoryUserDetailsManager(
              new User("user", "{noop}password", Collections.emptyList())
      );
    }
}
