package com.rajewski.jobfinder.webapp.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserLoginAuthenticationToken extends AbstractAuthenticationToken {

    public UserLoginAuthenticationToken() {
        super(null);
    }
}
