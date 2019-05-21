package com.rajewski.jobfinder.webapp.security;

import java.util.HashSet;
import java.util.Set;

public class CsrfTokenManager {

    private static Set<String> loginCsrfTokens = new HashSet<>();
}
