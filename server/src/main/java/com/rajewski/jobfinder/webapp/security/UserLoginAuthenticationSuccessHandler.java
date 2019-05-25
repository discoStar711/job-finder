package com.rajewski.jobfinder.webapp.security;

import com.rajewski.jobfinder.webapp.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        UserLoginAuthenticationToken authenticationPrincipal = (UserLoginAuthenticationToken) authentication;
        User authenticatedUser = authenticationPrincipal.getUser();
        Integer userId = authenticatedUser.getId();

    }
}
