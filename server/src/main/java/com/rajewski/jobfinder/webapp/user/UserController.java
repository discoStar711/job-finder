package com.rajewski.jobfinder.webapp.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Set-Cookie", "Access-Control-Allow-Origin", "CSRF-Token", "Access-Control-Allow-Credentials"}, allowCredentials = "true")
    @PostMapping("/auth")
    public ResponseEntity<String> loginAuthenticate(HttpServletRequest request, HttpServletResponse response, HttpEntity<String> httpEntity) {
        UserAuthenticationManager manager = new UserAuthenticationManager();
        return manager.authenticate(request, response, httpEntity);
    }

    @CrossOrigin
    @PostMapping("/new")
    public void saveUser(HttpEntity<String> httpEntity) {
        UserManager manager = new UserManager();
        manager.save(httpEntity);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Access-Control-Allow-Origin", "CSRF-Token", "Access-Control-Allow-Credentials"}, allowCredentials = "true")
    @PostMapping("/details")
    public User getUser(HttpServletRequest request) {
        UserManager userManager = new UserManager();
        return userManager.get(request);
    }
}
