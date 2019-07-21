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

    public void saveAll(List<GoogleJob> list)
    {
        for (GoogleJob job : list)
        {
            String insertIntoJob = "INSERT INTO job(title, url, description, experience_id, provider_id) VALUES" +
                    BEGIN_PARENTHESES +
                    QUOTE + job.getTitle() + QUOTE + COMMA +
                    QUOTE + job.getUrl() + QUOTE + COMMA +
                    QUOTE + job.getDescription() + QUOTE + COMMA +
                    job.getPositionId() + COMMA +
                    job.getProviderId() +
                    END_PARENTHESES;

            String insertIntoJobTechnology = "INSERT INTO JobTechnology(job_id, technology_id) VALUES" +
                    BEGIN_PARENTHESES +
                    "@jobId" + COMMA +
                    job.getTechnologyId() +
                    END_PARENTHESES;

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
            jdbcTemplate.execute(START_TRANSACTION);
            jdbcTemplate.execute(insertIntoJob);
            jdbcTemplate.execute("SET @jobId = LAST_INSERT_ID();");
            jdbcTemplate.execute(insertIntoJobTechnology);
            jdbcTemplate.execute(COMMIT);
        }
    }
}
