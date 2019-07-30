package com.rajewski.jobfinder.webapp.job;

public abstract class Job
{
    protected Integer id;
    protected String title;
    protected String description;
    protected String url;
    protected Integer positionId;
    protected Integer providerId;

    public Integer getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public String getUrl()
    {
        return url;
    }

    public Integer getPositionId()
    {
        return positionId;
    }

    public Integer getProviderId()
    {
        return providerId;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public void setPositionId(Integer positionId)
    {
        this.positionId = positionId;
    }

    public void setProviderId(Integer providerId)
    {
        this.providerId = providerId;
    }
}
