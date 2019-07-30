package com.rajewski.jobfinder.webapp.job;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController
{
    @GetMapping
    public String getJobsBy(@RequestParam String keyword) {
        return keyword;
    }
}
