package com.rajewski.jobfinder.webapp.find;

import java.util.List;

public class JobManager
{
    private void find()
    {
        try
        {
            JobFinder finder = new JobFinder();
            List<GoogleJob> jobs = finder.find();
            save(jobs);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void save(List<GoogleJob> jobs)
    {
        JobDao jobDao = new JobDao();
        jobDao.saveAll(jobs);
    }
}
