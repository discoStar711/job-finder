package com.rajewski.jobfinder.webapp.find.response.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"kind", "url", "queries", "context", "searchInformation", "spelling"})
public class GoogleResponse {

    GoogleItem[] items;

    public GoogleItem[] getItems()
    {
        return items;
    }

    public void setItems(GoogleItem[] items)
    {
        this.items = items;
    }
}
