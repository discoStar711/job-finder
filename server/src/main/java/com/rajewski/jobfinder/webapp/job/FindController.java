package com.rajewski.jobfinder.webapp.job;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/find")
public class FindController {

    @GetMapping("/job")
    public String getJobsBy(@RequestParam String keyword) {
        return keyword;
    }
}
