package com.training.boot.security.bootsecuritybasic.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class KhemaisAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var auth = (UsernamePasswordAuthenticationToken) authentication;
        // Si c'est khemais je prend une decision sinon je ne prends pas de décision
        if (auth.getName().equalsIgnoreCase("khemais")) {
            return new UsernamePasswordAuthenticationToken(
                    "khemais",
                    null,
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            );
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
