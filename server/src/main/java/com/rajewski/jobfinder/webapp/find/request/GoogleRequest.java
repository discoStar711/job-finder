package com.rajewski.jobfinder.webapp.find.request;

import java.util.Map;

public class GoogleRequest
{
    private static final String API_URL = "https://www.googleapis.com/customsearch/v1?";
    private static final String API_KEY = "key=";
    private static final String ID = "cx=";

    private Map<String, Object> jobProvider;
    private Map<String, Object> position;
    private Map<String, Object> technology;

    public GoogleRequest(
            Map<String, Object> jobProvider,
            Map<String, Object> position,
            Map<String, Object> technology
    )
    {
        this.jobProvider = jobProvider;
        this.position = position;
        this.technology = technology;
    }

    public Map<String, Object> fetch() throws Exception
    {

    }

    private String buildApiRequestUrl(String providerUrl, String position, String technology)
    {
        return API_URL + API_KEY + "&" + ID +
                "&q=" +
                "site:" +
                providerUrl +
                "+" +
                position +
                "+" +
                technology +
                "&dateRestrict=d8" +
                "&gl=uk";
    }
}
