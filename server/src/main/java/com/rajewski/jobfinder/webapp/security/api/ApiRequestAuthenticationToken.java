package com.rajewski.jobfinder.webapp.security.api;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class ApiRequestAuthenticationToken extends AbstractAuthenticationToken
{
    private String csrfToken;
    private String sessionId;

    public ApiRequestAuthenticationToken(String sessionId)
    {
        super(null);
        this.sessionId = sessionId;
    }

    public ApiRequestAuthenticationToken(String sessionId, boolean isAuthenticated)
    {
        super(null);
        this.sessionId = sessionId;
        setAuthenticated(isAuthenticated);
    }

    public ApiRequestAuthenticationToken(String sessionId, String csrfToken)
    {
        super(null);
        this.sessionId = sessionId;
        this.csrfToken = csrfToken;
    }

    public ApiRequestAuthenticationToken(String sessionId, String csrfToken, boolean isAuthenticated)
    {
        super(null);
        this.sessionId = sessionId;
        this.csrfToken = csrfToken;
        setAuthenticated(isAuthenticated);
    }

    public String getCsrfToken()
    {
        return csrfToken;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    @Override
    public Object getCredentials()
    {
        return "";
    }

    @Override
    public Object getPrincipal()
    {
        return "";
    }
}