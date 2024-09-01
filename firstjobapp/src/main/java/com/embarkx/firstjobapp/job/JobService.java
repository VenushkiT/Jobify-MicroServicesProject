package com.embarkx.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> FindAll();
    String CreateJob(Job job);
    Job getJobByID(Long id);
    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
