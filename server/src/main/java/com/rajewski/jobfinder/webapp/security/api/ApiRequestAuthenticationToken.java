package com.rajewski.jobfinder.webapp.security.api;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class ApiRequestAuthenticationToken extends AbstractAuthenticationToken {

    private String csrfToken;

    public ApiRequestAuthenticationToken() {
        super(null);
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getPrincipal() {
        return "";
    }
}