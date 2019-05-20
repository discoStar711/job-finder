package com.rajewski.jobfinder.webapp.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;

public class UserManager {

    public void save(HttpEntity<String> httpEntity) {
        String userDetails = httpEntity.getBody();
        try {
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(userDetails, User.class);

            UserDao userDao = new UserDao();
            userDao.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
