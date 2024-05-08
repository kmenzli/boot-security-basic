package com.training.boot.security.bootsecuritybasic.config;

import com.training.boot.security.bootsecuritybasic.filter.MyRebotFilter;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(new KhemaisAuthenticationProvider())
                .authorizeHttpRequests(
                        authorize -> authorize.requestMatchers("private").authenticated()
                        .anyRequest().permitAll()
                )
                .addFilterBefore(new MyRebotFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    UserDetailsService userDetailsService() {
      return new InMemoryUserDetailsManager(
              new User("user", passwordEncoder().encode("password"), Collections.emptyList())
      );
    }
}
