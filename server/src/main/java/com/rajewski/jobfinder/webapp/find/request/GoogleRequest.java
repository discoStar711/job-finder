package com.rajewski.jobfinder.webapp.find.request;

import com.rajewski.jobfinder.webapp.find.exception.GoogleFetchException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
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
        Integer providerId = (Integer) jobProvider.get("id");
        String providerUrl = (String) jobProvider.get("url");
        Integer positionId = (Integer) position.get("id");
        String positionName = (String) position.get("experience_level");
        Integer technologyId = (Integer) technology.get("id");
        String technologyName = (String) technology.get("name");

        String apiRequestUrl = buildApiRequestUrl(providerUrl, positionName, technologyName);

        Map<String, Object> result = new HashMap<>();
        try
        {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> apiResponse = restTemplate.getForEntity(apiRequestUrl, String.class, "");

            result.put("result", apiResponse.getBody());
            result.put("provider_id", providerId);
            result.put("experience_id", positionId);
            result.put("technology_id", technologyId);
        }
        catch (Exception ex)
        {
            throw new GoogleFetchException(ex);
        }
        return result;
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
