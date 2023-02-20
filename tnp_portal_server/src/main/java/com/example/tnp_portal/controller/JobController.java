package com.example.tnp_portal.controller;

import com.example.tnp_portal.service.JobServiceImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/job")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JobController {
    private JobServiceImpl service;

    @Autowired
    public JobController(JobServiceImpl service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllJobs(){
        return this.service.getAllJobs();
    }

    @GetMapping("/{company_id}")
    public ResponseEntity<?> getJobForCompany(@PathVariable(name = "company_id") ObjectId company_id){
        return this.service.getJobForCompany(company_id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable(name = "id")ObjectId id){
        return this.service.deleteJobById(id);
    }

    @PutMapping("")
    public ResponseEntity<?> updateJobById(@PathVariable(name = "id") ObjectId id, Map<String,?> body){
        return this.service.updateJobById(id,body);
    }
}
