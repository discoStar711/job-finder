package com.rajewski.jobfinder.webapp.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController
{
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Set-Cookie", "Access-Control-Allow-Origin", "CSRF-Token", "Access-Control-Allow-Credentials"}, allowCredentials = "true")
    @PostMapping("/auth")
    public ResponseEntity<String> loginAuthenticate()
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/new")
    public ResponseEntity<String> saveUser(HttpEntity<String> httpEntity)
    {
        UserManager manager = new UserManager();
        return manager.save(httpEntity);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Access-Control-Allow-Origin", "CSRF-Token", "Access-Control-Allow-Credentials"}, allowCredentials = "true")
    @PostMapping("/details")
    public User getUser(HttpServletRequest request)
    {
        UserManager userManager = new UserManager();
        return userManager.get(request);
    }
}
