package com.rajewski.jobfinder.webapp.security;

import java.util.HashSet;
import java.util.Set;

public class CsrfTokenManager {

    private static Set<String> loginCsrfTokens = new HashSet<>();

    public String getLoginToken() {
        String token = createToken();
        loginCsrfTokens.add(token);
        return token;
    }

    public String getSessionToken() {
        return createToken();
    }

    private String createToken() {
        CsrfToken csrfToken = new CsrfToken();
        return csrfToken.create();
    }

    public static boolean containsLoginCsrfToken(String token) {
        return loginCsrfTokens.contains(token);
    }
}
