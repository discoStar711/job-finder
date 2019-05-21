package com.rajewski.jobfinder.webapp.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

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
}
