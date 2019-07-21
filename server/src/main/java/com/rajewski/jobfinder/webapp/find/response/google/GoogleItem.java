package com.rajewski.jobfinder.webapp.find.response.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"kind", "htmlTitle", "displayLink", "htmlSnippet", "cacheId", "formattedUrl", "htmlFormattedUrl", "pagemap"})
public class GoogleItem {

    private String title;
    private String link;
    private String snippet;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public String getSnippet()
    {
        return snippet;
    }

    public void setSnippet(String snippet)
    {
        this.snippet = snippet;
    }
}
