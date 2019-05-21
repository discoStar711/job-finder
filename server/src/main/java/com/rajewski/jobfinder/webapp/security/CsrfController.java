package com.rajewski.jobfinder.webapp.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {

    @GetMapping("/csrfLogin")
    public String getCsrfLoginToken() {
        CsrfTokenManager manager = new CsrfTokenManager();
        return manager.getLoginToken();
    }
}
