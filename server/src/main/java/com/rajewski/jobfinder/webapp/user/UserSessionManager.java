package com.rajewski.jobfinder.webapp.user;

import java.util.HashMap;
import java.util.Map;

public class UserSessionManager {

    private static Map<String, UserSession> sessions = new HashMap<>();

    public void registerSession(String sessionId, UserSession userSession) {
        sessions.put(sessionId, userSession);
    }

    public static boolean isSessionValid(String sessionId, String csrfToken) {
        UserSession userSession = sessions.get(sessionId);

        if (userSession != null) {
            if (userSession.getSessionCsrfToken().equals(csrfToken)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static UserSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }
}