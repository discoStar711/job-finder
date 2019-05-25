package com.rajewski.jobfinder.webapp.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserLoginAuthenticationToken extends AbstractAuthenticationToken {

    private String csrfToken;

    public UserLoginAuthenticationToken() {
        super(null);
    }

    public String getCsrfToken() {
        return csrfToken;
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
