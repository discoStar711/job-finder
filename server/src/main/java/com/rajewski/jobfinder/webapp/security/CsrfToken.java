package com.rajewski.jobfinder.webapp.security;

import java.util.UUID;

public class CsrfToken
{
    public String create()
    {
        return UUID.randomUUID().toString();
    }
}
