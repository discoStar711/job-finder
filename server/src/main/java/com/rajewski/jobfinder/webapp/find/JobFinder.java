package com.rajewski.jobfinder.webapp.find;

import java.util.List;
import java.util.Map;

public class JobFinder
{
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
}
