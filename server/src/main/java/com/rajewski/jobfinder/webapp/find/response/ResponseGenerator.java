package com.rajewski.jobfinder.webapp.find.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajewski.jobfinder.webapp.find.response.google.GoogleResponse;

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

            try
            {
                ObjectMapper mapper = new ObjectMapper();
                GoogleResponse response = mapper.readValue(json, GoogleResponse.class);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return list;
    }

    private String escapeSingleQuote(String text)
    {
        return text.replace("'", "''");
    }
}
