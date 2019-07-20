package com.rajewski.jobfinder.webapp.find.response;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResponseGenerator
{
    public List<GoogleJob> getGoogleJobList(List<Map<String, Object>> data)
    {
        List<GoogleJob> list = new LinkedList<>();
        return list;
    }

    private String escapeSingleQuote(String text)
    {
        return text.replace("'", "''");
    }
}
