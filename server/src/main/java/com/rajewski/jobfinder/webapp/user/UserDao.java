package com.rajewski.jobfinder.webapp.user;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.util.Map;

public class UserDao {

    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jobs?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }

    public void save(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String encodedPassword = encoder.encode(password);
        String query = "INSERT INTO user (name, password, email) VALUES('" + username + "','" + encodedPassword + "','" + email + "');";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        jdbcTemplate.execute(query);
    }

    public User findByUsername(String username) {
        String query = "SELECT id, password FROM user WHERE name = '" + username + "';";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        Map<String, Object> map = jdbcTemplate.queryForMap(query);

        return User.mapToObject(map);
    }

    public User findUserById(Integer id) {
        String query = "SELECT name, email FROM user WHERE id = " + id + ";";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        Map<String, Object> map = jdbcTemplate.queryForMap(query);

        return User.mapToObject(map);
    }
}
