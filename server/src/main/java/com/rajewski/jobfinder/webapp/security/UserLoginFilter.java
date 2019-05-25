package com.rajewski.jobfinder.webapp.security;

import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class UserLoginFilter extends AbstractAuthenticationProcessingFilter {

    public UserLoginFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }
}
