package com.rajewski.jobfinder.webapp.find;

import java.util.List;

public class JobManager
{
    private void save(List<GoogleJob> jobs)
    {
        JobDao jobDao = new JobDao();
        jobDao.saveAll(jobs);
    }
}
