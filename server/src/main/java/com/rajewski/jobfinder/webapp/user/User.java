package com.rajewski.jobfinder.webapp.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties({"id"})
public class User
{
    private Integer id;
    private String username;
    private String email;
    private String password;

    public User() {}

    public User(String username, String email)
    {
        this.username = username;
        this.email = email;
    }

    public Integer getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public static User mapToObject(Map<String, Object> map)
    {
        User user = new User();
        user.setId((Integer) map.get("id"));
        user.setUsername((String) map.get("name"));
        user.setPassword((String) map.get("password"));
        user.setEmail((String) map.get("email"));
        return user;
    }
}
