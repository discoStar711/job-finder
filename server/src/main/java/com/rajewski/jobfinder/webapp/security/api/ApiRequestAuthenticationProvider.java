package com.rajewski.jobfinder.webapp.security.api;

import com.rajewski.jobfinder.webapp.user.UserSessionManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ApiRequestAuthenticationProvider implements AuthenticationProvider
{
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        if (supports(authentication.getClass()))
        {
            return validateSession((ApiRequestAuthenticationToken)authentication);
        }
        else
        {
            throw new AuthenticationServiceException("Could not authenticate session or CSRF token.");
        }
    }

    @Override
    public boolean supports(Class<?> aClass)
    {
        return aClass.equals(ApiRequestAuthenticationToken.class);
    }
    
    private ApiRequestAuthenticationToken validateSession(ApiRequestAuthenticationToken token)
    {
        String sessionId = token.getSessionId();
        String csrfToken = token.getCsrfToken();

        if (UserSessionManager.isSessionValid(sessionId, csrfToken))
        {
            return new ApiRequestAuthenticationToken(sessionId, csrfToken, true);
        }
        else
        {
            return new ApiRequestAuthenticationToken(sessionId, csrfToken, false);
        }
    }
}