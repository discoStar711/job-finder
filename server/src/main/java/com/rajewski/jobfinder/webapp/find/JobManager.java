package com.rajewski.jobfinder.webapp.find;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class JobManager
{
    private static final long HOUR = 1000 * 60 * 60;
    private static final long TWELVE_HOURS = 12 * HOUR;

    private void scheduleNextJobFetch()
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                
            }
        }, TWELVE_HOURS);
    }

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
