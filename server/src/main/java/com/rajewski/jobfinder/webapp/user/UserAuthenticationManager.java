package com.rajewski.jobfinder.webapp.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajewski.jobfinder.webapp.security.CsrfTokenManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAuthenticationManager {

    public ResponseEntity<String> authenticate(HttpServletRequest request, HttpServletResponse response, HttpEntity<String> httpEntity) {

        String csrfToken = request.getHeader("CSRF-Token");
        CsrfTokenManager csrfTokenManager = new CsrfTokenManager();

        if (csrfTokenManager.containsLoginCsrfToken(csrfToken)) {

            ResponseEntity<String> responseEntity;
            try {
                String credentials = httpEntity.getBody();

                ObjectMapper mapper = new ObjectMapper();
                User user = mapper.readValue(credentials, User.class);

                UserDao userDao = new UserDao();
                User retrievedDbUser = userDao.findByUsername(user.getUsername());

                if (BCrypt.checkpw(user.getPassword(), retrievedDbUser.getPassword())) {

                    String sessionId = request.getSession().getId();
                    String sessionCsrfToken = csrfTokenManager.getSessionToken();
                    UserSession userSession = new UserSession(retrievedDbUser.getId(), sessionCsrfToken);

                    UserSessionManager userSessionManager = new UserSessionManager();
                    userSessionManager.registerSession(sessionId, userSession);

                    responseEntity = new ResponseEntity<>(HttpStatus.OK);
                } else {
                    responseEntity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return responseEntity;
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}