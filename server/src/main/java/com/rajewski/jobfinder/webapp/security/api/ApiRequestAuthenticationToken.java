package com.rajewski.jobfinder.webapp.security.api;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class ApiRequestAuthenticationToken extends AbstractAuthenticationToken {

    public ApiRequestAuthenticationToken() {
        super(null);
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