package com.rajewski.jobfinder.webapp.find.request;

import java.util.*;

public class RequestGenerator
{
    public List<Map<String, Object>> getJobsFromGoogleBy(
            List<Map<String, Object>> jobProviders,
            List<Map<String, Object>> positions,
            List<Map<String, Object>> technologies
    )
    {
        List<Map<String, Object>> responseList = new LinkedList<>();
        Timer timer = new Timer();
        int delayTimeCounter = 0;

        for (Map<String, Object> jobProvider : jobProviders)
        {
            for (Map<String, Object> position : positions)
            {
                for (Map<String, Object> technology : technologies)
                {
                    delayTimeCounter += 1;
                    timer.schedule(new TimerTask()
                    {
                        @Override
                        public void run()
                        {
                            GoogleRequest request = new GoogleRequest(jobProvider, position, technology);
                            Map<String, Object> response = request.fetch();
                            responseList.add(response);
                        }
                    }, 5000 * delayTimeCounter);
                }
            }
        }
        return responseList;
    }
}
