package com.rajewski.jobfinder.webapp.find;

public class GoogleJob extends Job
{
    private Integer technologyId;

    public GoogleJob(
            String title,
            String description,
            String url,
            Integer positionId,
            Integer providerId,
            Integer technologyId
    )
    {
        this.title = title;
        this.description = description;
        this.url = url;
        this.positionId = positionId;
        this.providerId = providerId;
        this.technologyId = technologyId;
    }

    public Integer getTechnologyId()
    {
        return technologyId;
    }

    public void setTechnologyId(Integer technologyId)
    {
        this.technologyId = technologyId;
    }
}
