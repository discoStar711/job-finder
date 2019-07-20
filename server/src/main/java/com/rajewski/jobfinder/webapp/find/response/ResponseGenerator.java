package com.rajewski.jobfinder.webapp.find.response;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResponseGenerator
{
    public List<GoogleJob> getGoogleJobList(List<Map<String, Object>> jobs)
    {
        List<GoogleJob> list = new LinkedList<>();

        for (Map<String, Object> job : jobs)
        {
            String json = (String) job.get("result");
            Integer positionId = (Integer) job.get("experience_id");
            Integer providerId = (Integer) job.get("provider_id");
            Integer technologyId = (Integer) job.get("technology_id");
        }
        return list;
    }

    private String escapeSingleQuote(String text)
    {
        return text.replace("'", "''");
    }
}
