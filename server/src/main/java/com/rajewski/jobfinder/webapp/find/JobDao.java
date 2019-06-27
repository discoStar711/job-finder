package com.rajewski.jobfinder.webapp.find;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class JobDao
{
    public DataSource dataSource()
    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jobs?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
}
