package com.rajewski.jobfinder.webapp.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserLoginAuthenticationToken extends AbstractAuthenticationToken {

    private String csrfToken;
    private String credentials;

    public UserLoginAuthenticationToken(String csrfToken, String credentials) {
        super(null);
        this.csrfToken = csrfToken;
        this.credentials = credentials;
    }

    public UserLoginAuthenticationToken(String csrfToken, String credentials, boolean isAuthenticated) {
        super(null);
        this.csrfToken = csrfToken;
        this.credentials = credentials;
        setAuthenticated(isAuthenticated);
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    @Override
    public String getCredentials() {
        return credentials;
    }

    @Override
    public String getPrincipal() {
        return "";
    }
}
