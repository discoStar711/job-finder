package com.rajewski.jobfinder.webapp.user;

import java.util.HashMap;
import java.util.Map;

public class UserSessionManager {

    private static Map<String, UserSession> sessions = new HashMap<>();

    public void registerSession(String sessionId, UserSession userSession) {
        sessions.put(sessionId, userSession);
    }
}