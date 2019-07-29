package com.rajewski.jobfinder.webapp.security.api;

import com.rajewski.jobfinder.webapp.security.CsrfTokenManager;
import com.rajewski.jobfinder.webapp.user.UserSessionManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiRequestAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException
    {
        ApiRequestAuthenticationToken authenticatedPrincipal = (ApiRequestAuthenticationToken) authentication;

        if (authenticatedPrincipal.getCsrfToken() != null)
        {
            String sessionId = authenticatedPrincipal.getSessionId();
            CsrfTokenManager csrfTokenManager = new CsrfTokenManager();
            String newSessionCsrfToken = csrfTokenManager.getSessionToken();

            UserSessionManager userSessionManager = new UserSessionManager();
            userSessionManager.updateCsrfToken(sessionId, newSessionCsrfToken);

            Cookie csrfTokenCookie = new Cookie("CSRF-Token", newSessionCsrfToken);
            csrfTokenCookie.setPath("/");
            response.addCookie(csrfTokenCookie);
        }

        request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
    }
}
