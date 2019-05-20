package com.rajewski.jobfinder.webapp.user;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @CrossOrigin
    @PostMapping("/new")
    public void saveUser(HttpEntity<String> httpEntity) {
        UserManager manager = new UserManager();
        manager.save(httpEntity);
    }
}
