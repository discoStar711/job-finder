package com.rajewski.jobfinder.webapp.find;

import java.util.List;
import java.util.Map;

public class JobFinder
{
    public List<GoogleJob> find()
    {
        List<Map<String, Object>> technologies = getAllTechnologies();
        List<Map<String, Object>> jobProviders = getAllJobProviders();
        List<Map<String, Object>> positions = getAllPositions();
    }

    private List<Map<String, Object>> getAllJobProviders()
    {
        JobDao jobDao = new JobDao();
        return jobDao.findAllJobProviders();
    }

    private List<Map<String, Object>> getAllPositions()
    {
        JobDao jobDao = new JobDao();
        return jobDao.findAllPositions();
    }

    private List<Map<String, Object>> getAllTechnologies()
    {
        JobDao jobDao = new JobDao();
        return jobDao.findAllTechnologies();
    }
}
