package com.rajewski.jobfinder.webapp.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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

    public User get(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        Cookie sessionId = getCookie(cookies, "JSESSIONID");

        Integer userId = UserSessionManager.getSession(sessionId.getValue()).getUserId();
        UserDao userDao = new UserDao();
        return userDao.findUserById(userId);
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
