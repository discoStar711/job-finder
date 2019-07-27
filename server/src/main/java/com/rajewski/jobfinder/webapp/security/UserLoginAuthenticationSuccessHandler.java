package com.rajewski.jobfinder.webapp.security;

import com.rajewski.jobfinder.webapp.user.User;
import com.rajewski.jobfinder.webapp.user.UserSession;
import com.rajewski.jobfinder.webapp.user.UserSessionManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        UserLoginAuthenticationToken authenticationPrincipal = (UserLoginAuthenticationToken) authentication;
        User authenticatedUser = authenticationPrincipal.getUser();
        Integer userId = authenticatedUser.getId();

        CsrfTokenManager csrfTokenManager = new CsrfTokenManager();
        String sessionCsrfToken = csrfTokenManager.getSessionToken();
        UserSession userSession = new UserSession(userId, sessionCsrfToken);
        String sessionId = request.getSession().getId();

        UserSessionManager userSessionManager = new UserSessionManager();
        userSessionManager.registerSession(sessionId, userSession);

        Cookie csrfTokenCookie = new Cookie("CSRF-Token", sessionCsrfToken);
        csrfTokenCookie.setPath("/");
        csrfTokenCookie.setMaxAge(10000);
        response.addCookie(csrfTokenCookie);

        request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
    }
}
