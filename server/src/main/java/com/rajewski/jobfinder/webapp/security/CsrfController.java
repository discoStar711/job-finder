package com.rajewski.jobfinder.webapp.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController
{
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept",  "Access-Control-Allow-Origin"})
    @GetMapping("/csrfLogin")
    public String getCsrfLoginToken()
    {
        CsrfTokenManager manager = new CsrfTokenManager();
        return manager.getLoginToken();
    }
}
