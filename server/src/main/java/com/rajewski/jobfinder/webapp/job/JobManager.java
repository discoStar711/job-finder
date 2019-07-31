package com.rajewski.jobfinder.webapp.job;

import com.rajewski.jobfinder.webapp.find.JobFinder;
import com.rajewski.jobfinder.webapp.find.response.GoogleJob;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class JobManager
{
    private static final long HOUR = 1000 * 60 * 60;
    private static final long TWELVE_HOURS = 12 * HOUR;

    public void fetchJobs()
    {
        scheduleNextJobFetch();
        fetch();
    }

    private void scheduleNextJobFetch()
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                fetchJobs();
            }
        }, TWELVE_HOURS);
    }

    private void fetch()
    {
        JobFinder finder = new JobFinder();
        List<GoogleJob> jobs = finder.find();
        save(jobs);
    }

    private void save(List<GoogleJob> jobs)
    {
        JobDao jobDao = new JobDao();
        jobDao.saveAll(jobs);
    }
}
