package com.rajewski.jobfinder.webapp.find;

import com.rajewski.jobfinder.webapp.find.request.RequestGenerator;
import com.rajewski.jobfinder.webapp.find.response.GoogleJob;
import com.rajewski.jobfinder.webapp.find.response.ResponseGenerator;
import com.rajewski.jobfinder.webapp.job.JobDao;

import java.util.List;
import java.util.Map;

public class JobFinder
{
    public List<GoogleJob> find()
    {
        List<Map<String, Object>> technologies = getAllTechnologies();
        List<Map<String, Object>> jobProviders = getAllJobProviders();
        List<Map<String, Object>> positions = getAllPositions();
        RequestGenerator requestGenerator = new RequestGenerator();
        List<Map<String, Object>> requestedData = requestGenerator.getJobsFromGoogleBy(jobProviders, positions, technologies);
        ResponseGenerator responseGenerator = new ResponseGenerator();
        return responseGenerator.getGoogleJobList(requestedData);
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
