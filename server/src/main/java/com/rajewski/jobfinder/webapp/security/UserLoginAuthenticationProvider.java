package com.rajewski.jobfinder.webapp.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class UserLoginAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (supports(authentication.getClass())) {
            
        } else {
            throw new AuthenticationServiceException("Could not authenticate.");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {

        if (aClass.equals(UserLoginAuthenticationToken.class)) {
            return true;
        } else {
            return false;
        }
    }
}