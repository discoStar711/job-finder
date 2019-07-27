package com.rajewski.jobfinder.webapp.user;

public class UserSession
{
    private Integer userId;
    private String sessionCsrfToken;

    public UserSession(Integer userId, String sessionCsrfToken)
    {
        this.userId = userId;
        this.sessionCsrfToken = sessionCsrfToken;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public String getSessionCsrfToken()
    {
        return sessionCsrfToken;
    }
}
