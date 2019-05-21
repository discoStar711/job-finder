package com.rajewski.jobfinder.webapp.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
                    .antMatchers("/user/auth").permitAll()
                    .antMatchers("/user/new").permitAll()
                    .anyRequest().authenticated();
    }
}