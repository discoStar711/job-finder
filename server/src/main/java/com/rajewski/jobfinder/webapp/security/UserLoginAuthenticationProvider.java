package com.rajewski.jobfinder.webapp.security;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajewski.jobfinder.webapp.user.User;
import com.rajewski.jobfinder.webapp.user.UserDao;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserLoginAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (supports(authentication.getClass())) {
            return validateCredentials((UserLoginAuthenticationToken)authentication);
        } else {
            throw new AuthenticationServiceException("Could not authenticate.");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {

        if (aClass.equals(UserLoginAuthenticationToken.class)) {
            return true;
        } else {
            return false;
        }
    }

    private UserLoginAuthenticationToken validateCredentials(UserLoginAuthenticationToken token) {

        String csrfToken = token.getCsrfToken();
        String credentials = token.getCredentials();

        if (CsrfTokenManager.containsLoginCsrfToken(csrfToken)) {

            UserLoginAuthenticationToken authenticationPrincipal;
            try {
                ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                User user = mapper.readValue(credentials, User.class);

                UserDao userDao = new UserDao();
                User retrievedDbUser = userDao.findByUsername(user.getUsername());

                if (BCrypt.checkpw(user.getPassword(), retrievedDbUser.getPassword())) {
                    authenticationPrincipal = new UserLoginAuthenticationToken(retrievedDbUser, true);
                } else {
                    authenticationPrincipal = new UserLoginAuthenticationToken(user, false);
                }
            } catch (Exception ex) {

                ex.printStackTrace();
                User user = new User();
                authenticationPrincipal = new UserLoginAuthenticationToken(user, false);
            }
            return authenticationPrincipal;
        } else {
            User user = new User();
            return new UserLoginAuthenticationToken(user, false);
        }
    }
}