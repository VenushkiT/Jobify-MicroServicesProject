package com.embarkx.firstjobapp.job.impl;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.job.JobRepository;
import com.embarkx.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

   // private List<Job> jobs = new ArrayList<Job>();
    JobRepository jobRepository;
    private Long nextID=1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> FindAll() {
        return jobRepository.findAll();
    }

    @Override
    public String CreateJob(Job job) {
        jobRepository.save(job);
        return "job added successfully";

    }

    @Override
    public Job getJobByID(Long id) {
       return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
       try {
           jobRepository.deleteById(id);
           return true;
       }catch (Exception e) {
           return false;
       }

    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional=jobRepository.findById(id);
        if(jobOptional.isPresent()) {
            Job job =jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
            }
        return false;
    }
}
