package com.rajewski.jobfinder.webapp.find;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class JobDao
{
    private static final String START_TRANSACTION = "START TRANSACTION";
    private static final String COMMIT = "COMMIT";
    private static final String BEGIN_PARENTHESES = "(";
    private static final String END_PARENTHESES = ")";
    private static final String QUOTE = "'";
    private static final String COMMA = ",";

    public DataSource dataSource()
    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jobs?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

    public List<Map<String, Object>> findAllTechnologies()
    {
        String query = "SELECT * FROM Technology";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate.queryForList(query);
    }

    public List<Map<String, Object>> findAllJobProviders()
    {
        String query = "SELECT * FROM Provider";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate.queryForList(query);
    }

    public List<Map<String, Object>> findAllPositions()
    {
        String query = "SELECT * FROM Position";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate.queryForList(query);
    }

    private String escapeSingleQuote(String text)
    {
        return text.replace("'", "''");
    }
}
