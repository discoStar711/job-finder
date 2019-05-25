package com.rajewski.jobfinder.webapp.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserLoginAuthenticationToken extends AbstractAuthenticationToken {

    public UserLoginAuthenticationToken(String csrfToken, String credentials) {
        super(null);
    }

    @Override
    public String getCredentials() {
        return "";
    }

    @Override
    public String getPrincipal() {
        return "";
    }
}
