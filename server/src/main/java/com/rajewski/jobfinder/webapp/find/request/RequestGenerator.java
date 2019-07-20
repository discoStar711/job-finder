package com.rajewski.jobfinder.webapp.find.request;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RequestGenerator
{
    public List<Map<String, Object>> getJobsFromGoogleBy(
            List<Map<String, Object>> jobProviders,
            List<Map<String, Object>> positions,
            List<Map<String, Object>> technologies
    ) throws Exception
    {
        List<Map<String, Object>> responseList = new LinkedList<>();

        for (Map<String, Object> jobProvider : jobProviders)
        {
            for (Map<String, Object> position : positions)
            {
                for (Map<String, Object> technology : technologies)
                {
                    
                }
            }
        }
        return responseList;
    }
}
