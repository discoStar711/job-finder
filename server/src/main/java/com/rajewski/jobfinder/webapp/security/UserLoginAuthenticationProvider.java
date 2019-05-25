package com.rajewski.jobfinder.webapp.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class UserLoginAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    }

    @Override
    public boolean supports(Class<?> aClass) {

    }
}
