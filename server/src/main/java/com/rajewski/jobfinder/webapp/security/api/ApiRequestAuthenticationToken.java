package com.rajewski.jobfinder.webapp.security.api;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class ApiRequestAuthenticationToken extends AbstractAuthenticationToken {

    private String csrfToken;
    private String sessionId;

    public ApiRequestAuthenticationToken(String sessionId, String csrfToken) {
        super(null);
        this.sessionId = sessionId;
        this.csrfToken = csrfToken;
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    public String getSessionId() {
        return sessionId;
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