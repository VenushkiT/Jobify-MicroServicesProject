package com.embarkx.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobController {
   private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity <List<Job>> findAll(){
        return ResponseEntity.ok(jobService.FindAll());
    }
    @PostMapping
    public ResponseEntity<String> CreateJob(@RequestBody Job job){
        jobService.CreateJob(job);
        return new ResponseEntity<>("Job created",HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job=jobService.getJobByID(id);
        if(job!=null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteJob(@PathVariable Long id){
    boolean deleted=jobService.deleteJobById(id);
    if(deleted)
        return new ResponseEntity<>("Job deleted",HttpStatus.OK);
    return new ResponseEntity<>("Job not deleted",HttpStatus.NOT_FOUND);
}
    @PutMapping("/{id}")
    public ResponseEntity<String> UpdateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id,updatedJob);
        if(updated)
            return new ResponseEntity<>("Job updated",HttpStatus.OK);
        return new ResponseEntity<>("Job not updated",HttpStatus.NOT_FOUND);
    }


}

