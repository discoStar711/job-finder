package com.rajewski.jobfinder.webapp.security.api;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiRequestFilter extends AbstractAuthenticationProcessingFilter
{
    public ApiRequestFilter(RequestMatcher requiresAuthenticationRequestMatcher)
    {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws AuthenticationException, IOException, ServletException
    {
        Cookie[] cookies = request.getCookies();
        String sessionId = getCookie(cookies, "JSESSIONID").getValue();
        String csrfToken = request.getHeader("CSRF-Token");

        if (sessionId != null && !sessionId.isEmpty() && csrfToken != null && !csrfToken.isEmpty())
        {
            ApiRequestAuthenticationToken token = new ApiRequestAuthenticationToken(sessionId, csrfToken);
            return getAuthenticationManager().authenticate(token);
        }
        else
        {
            throw new AuthenticationServiceException("Could not authenticate user.");
        }
    }

    private Cookie getCookie(Cookie[] cookies, String name)
    {
        for (Cookie cookie : cookies)
        {
            if (name.equals(cookie.getName()))
            {
                return cookie;
            }
        }
        return new Cookie("", "");
    }
}