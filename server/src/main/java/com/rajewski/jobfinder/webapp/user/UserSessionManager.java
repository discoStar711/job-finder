package com.rajewski.jobfinder.webapp.user;

import java.util.HashMap;
import java.util.Map;

public class UserSessionManager
{
    private static Map<String, UserSession> sessions = new HashMap<>();

    public static boolean isSessionValid(String sessionId, String csrfToken)
    {
        UserSession userSession = sessions.get(sessionId);

        if (userSession != null)
        {
            return userSession.getSessionCsrfToken().equals(csrfToken);
        }
        else
        {
            return false;
        }
    }

    public static UserSession getSession(String sessionId)
    {
        return sessions.get(sessionId);
    }

    public void registerSession(String sessionId, UserSession userSession)
    {
        sessions.put(sessionId, userSession);
    }

    public void updateCsrfToken(String sessionId, String csrfToken)
    {
        UserSession userSession = getSession(sessionId);
        userSession.setSessionCsrfToken(csrfToken);
        registerSession(sessionId, userSession);
    }
}