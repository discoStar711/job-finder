package com.rajewski.jobfinder.webapp.config;

import com.rajewski.jobfinder.webapp.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/csrfLogin").permitAll()
                .antMatchers("/find/**").permitAll()
                .antMatchers("/user/details").permitAll()
                .antMatchers("/user/new").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(getUserLoginFilter(), AnonymousAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(new UserLoginAuthenticationProvider());
    }

    @Bean
    public UserLoginFilter getUserLoginFilter() {
        UserLoginFilter filter = new UserLoginFilter(new AntPathRequestMatcher("/user/auth"));
        filter.setAuthenticationManager(getAuthenticationManager());
        filter.setAuthenticationSuccessHandler(new UserLoginAuthenticationSuccessHandler());
        return filter;
    }

    @Bean
    AuthenticationManager getAuthenticationManager() {
        AuthenticationManager authenticationManager = null;
        try {
            authenticationManager = super.authenticationManager();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return authenticationManager;
    }
}