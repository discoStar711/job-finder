package com.rajewski.jobfinder.webapp.find.response;

public class ResponseGenerator
{
    private String escapeSingleQuote(String text)
    {
        return text.replace("'", "''");
    }
}
