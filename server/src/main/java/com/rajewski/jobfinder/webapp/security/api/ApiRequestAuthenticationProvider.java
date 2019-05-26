package com.rajewski.jobfinder.webapp.security.api;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ApiRequestAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    }

    @Override
    public boolean supports(Class<?> aClass) {

    }
}