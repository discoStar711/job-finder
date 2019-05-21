package com.rajewski.jobfinder.webapp.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajewski.jobfinder.webapp.security.CsrfTokenManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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