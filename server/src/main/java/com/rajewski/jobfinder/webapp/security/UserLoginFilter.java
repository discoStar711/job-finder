package com.rajewski.jobfinder.webapp.security;

import org.apache.commons.io.IOUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginFilter extends AbstractAuthenticationProcessingFilter {

    public UserLoginFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String csrfToken = request.getHeader("CSRF-Token");
        String credentials = IOUtils.toString(request.getReader());

        if (csrfToken != null && !csrfToken.isEmpty()) {
            UserLoginAuthenticationToken token = new UserLoginAuthenticationToken(csrfToken, credentials);
        } else {
            throw new AuthenticationServiceException("Could not authenticate CSRF token.");
        }
    }
}
