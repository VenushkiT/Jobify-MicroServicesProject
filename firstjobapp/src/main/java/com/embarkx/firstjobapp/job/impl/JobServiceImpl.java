package com.embarkx.firstjobapp.job.impl;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<Job>();
    @Override
    public List<Job> FindAll() {
        return jobs;
    }

    @Override
    public String CreateJob(Job job) {
        jobs.add(job);
        return "job added successfully";

    }
}
