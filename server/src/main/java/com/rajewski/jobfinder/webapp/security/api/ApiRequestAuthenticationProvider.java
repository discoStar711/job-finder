package com.rajewski.jobfinder.webapp.security.api;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ApiRequestAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (supports(authentication.getClass())) {

        } else {
            throw new AuthenticationServiceException("Could not authenticate session or CSRF token.");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {

        if (aClass.equals(ApiRequestAuthenticationToken.class)) {
            return true;
        } else {
            return false;
        }
    }
}