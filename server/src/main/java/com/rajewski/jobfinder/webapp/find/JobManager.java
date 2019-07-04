package com.rajewski.jobfinder.webapp.find;

import java.util.List;

public class JobManager
{
    private static final long HOUR = 1000 * 60 * 60;
    private static final long TWELVE_HOURS = 12 * HOUR;

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
