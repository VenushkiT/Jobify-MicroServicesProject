package com.embarkx.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> FindAll();
    String CreateJob(Job job);
}
