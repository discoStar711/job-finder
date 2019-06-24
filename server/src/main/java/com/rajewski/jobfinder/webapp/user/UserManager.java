package com.rajewski.jobfinder.webapp.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class UserManager {

    public ResponseEntity<String> save(HttpEntity<String> httpEntity) {
        String userDetails = httpEntity.getBody();
        try {
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(userDetails, User.class);

            if (isRegistered(user)) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            } else {
                UserDao userDao = new UserDao();
                userDao.save(user);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public User get(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        Cookie sessionId = getCookie(cookies, "JSESSIONID");

        Integer userId = UserSessionManager.getSession(sessionId.getValue()).getUserId();
        UserDao userDao = new UserDao();
        return userDao.findUserById(userId);
    }

    private boolean isRegistered(User userToRegister) {
        UserDao userDao = new UserDao();
        User retrievedUser = userDao.findByUsername(userToRegister.getUsername());
        return userToRegister.getUsername().equals(retrievedUser.getUsername());
    }

    private Cookie getCookie(Cookie[] cookies, String name) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return new Cookie("", "");
    }
}
